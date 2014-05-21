
// Represents a savings account
public class Savings extends Account{

    double interest; // The interest rate

    public Savings(int accountNum, int balance, String name, double interest){
        super(accountNum, balance, name);
        this.interest = interest;
    }
    
    public void withdraw(int amount){
        int newbalance = this.balance - amount;
        if(newbalance <= 0)
            throw new RuntimeException("Cannot withdraw more than what is in the account");
        this.balance = newbalance;
    }
    
    public void deposit(int amount){
        this.balance += amount;
    }
}
