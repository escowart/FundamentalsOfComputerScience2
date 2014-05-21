
// Represents a credit line account
public class Credit extends Account{

    int creditLine;  // Maximum amount accessible
    double interest; // The interest rate charged
    
    public Credit(int accountNum, int balance, String name, int creditLine, double interest){
        super(accountNum, balance, name);
        this.creditLine = creditLine;
        this.interest = interest;
    }
    
    public void withdraw(int amount){
        int newbalance = this.balance + amount;
        if(this.creditLine < newbalance)
            throw new RuntimeException("Cannot have that much credit");
        this.balance = newbalance;
    }
    
    public void deposit(int amount){
        int newbalance = this.balance - amount;
        if (newbalance < 0)
            throw new RuntimeException("Cannot have negative credit");
        this.balance = newbalance;
    }
}
