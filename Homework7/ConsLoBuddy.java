// represents a list of Person's buddies
class ConsLoBuddy implements ILoBuddy {

    Person first;
    ILoBuddy rest;

    ConsLoBuddy(Person first, ILoBuddy rest) {
        this.first = first;
        this.rest = rest;
    }

    // Does the cons list contain the person?
    public boolean contains(Person that) {
        return this.first.samePerson(that) || this.rest.contains(that);
    }

    // Count the number of buddies they have in common.
    public int countCommonBuddies(ILoBuddy that) {
        if (that.contains(this.first))
            return 1 + this.rest.countCommonBuddies(that);
        return this.rest.countCommonBuddies(that);
    }

    // Is the Person a Buddy of Any of Persons?
    public boolean isBuddyofAny(Person that) {
        return this.first.buddies.contains(that)
                || this.rest.isBuddyofAny(that);
    }

    // What is the length of the Buddy list
    public int length() {
        return 1 + this.rest.length();
    }

    // Party count on the list
    public ILoBuddy listParty(ILoBuddy blacklist) {
        if (blacklist.contains(this.first))
            return this.rest.listParty(blacklist);
        return this.rest.listParty(this.first.buddies
                .listParty(new ConsLoBuddy(this.first, blacklist)));
    }
}
