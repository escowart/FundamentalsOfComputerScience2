
// Represents the empty List of Accounts
public class MtLoA implements ILoA{
    
    MtLoA(){}
    
    public void deposit(int account, int amount){
        throw new RuntimeException("Their is no account " + account);
    }
    
    public ILoA removeAccount(int account){
        throw new RuntimeException("Cannot remove " + account + " because it is not in the bank");
    }
}

