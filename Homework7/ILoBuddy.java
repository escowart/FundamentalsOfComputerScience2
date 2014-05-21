
// represents a list of Person's buddies
interface ILoBuddy {
    
    // Does the list contain the person?
    public boolean contains(Person that);
    
    // Count the number of buddies they have in common.
    public int countCommonBuddies(ILoBuddy that);
    
    // Is the Person a Buddy of Any of Persons?
    public boolean isBuddyofAny(Person that);
    
    // What is the length of the Buddy list
    public int length();
    
    // Party count on the list
    public ILoBuddy listParty(ILoBuddy blacklist);
}
