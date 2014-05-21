
// Represents a non-empty List of Accounts...
public class ConsLoA implements ILoA{

    Account first;
    ILoA rest;

    public ConsLoA(Account first, ILoA rest){
        this.first = first;
        this.rest = rest;
    }
    
    /* Template
     *  Fields:
     *    ... this.first ...         --- Account
     *    ... this.rest ...          --- ILoA
     *
     *  Methods:
     *
     *  Methods for Fields:
     *
     */
    
    public void deposit(int amount, int account){
        if(this.first.accountNum == account)
            this.first.deposit(amount);
        this.rest.deposit(amount, account);
    }
    
    public ILoA removeAccount(int account){
        if(this.first.accountNum == account)
            return this.rest;
        return new ConsLoA(this.first, this.rest.removeAccount(account));
    }
}