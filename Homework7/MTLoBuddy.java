// represents an empty list of Person's buddies
class MTLoBuddy implements ILoBuddy {
    MTLoBuddy() {
    }

    // Does the empty list contain the person?
    public boolean contains(Person that) {
        return false;
    }

    // Count the number of buddies they have in common.
    public int countCommonBuddies(ILoBuddy that) {
        return 0;
    }

    // Is the Person a Buddy of Any of Persons?
    public boolean isBuddyofAny(Person that) {
        return false;
    }

    // What is the length of the Buddy list
    public int length() {
        return 0;
    }

    public ILoBuddy listParty(ILoBuddy blacklist) {
        return blacklist;
    }
}
