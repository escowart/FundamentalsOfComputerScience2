
// Represents a checking account
public class Checking extends Account{

    int minimum; // The minimum account balance allowed

    public Checking(int accountNum, int balance, String name, int minimum){
        super(accountNum, balance, name);
        this.minimum = minimum;
    }
    
    public void withdraw(int amount){
        int newbalance = this.balance - amount;
        if(this.minimum > newbalance)
            throw new RuntimeException("Cannot withdraw past the minimum");
        this.balance = newbalance;
    }
    
    public void deposit(int amount){
        this.balance += amount;
    }
}
