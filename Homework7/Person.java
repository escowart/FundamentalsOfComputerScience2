// represents a Person with a user name and a list of buddies
class Person {

    String username;
    ILoBuddy buddies;

    Person(String username) {
        this.username = username;
        this.buddies = new MTLoBuddy();
    }

    // returns true if this Person has that as a direct buddy
    boolean hasDirectBuddy(Person that) {
        return this.buddies.contains(that);
    }

    // returns the number of people who will show up at the party
    // given by this person
    int partyCount() {
        return this.buddies.listParty(new ConsLoBuddy(this, new MTLoBuddy()))
                .length() - 1;
    }

    // returns the number of people that are direct buddies
    // of both this and that person
    int countCommonBuddies(Person that) {
        return this.buddies.countCommonBuddies(that.buddies);
    }

    // will the given person be invited to a party
    // organized by this person?
    boolean hasDistantBuddy(Person that) {
        return this.buddies.listParty(new MTLoBuddy()).contains(that);
    }

    // Add a buddy to the List of Buddies
    void addBuddy(Person bud) {
        this.buddies = new ConsLoBuddy(bud, this.buddies);
    }

    // Do the two people have the same name?
    boolean samePerson(Person that) {
        return this.username.equals(that.username);
    }
}
