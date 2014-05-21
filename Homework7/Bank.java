
// Represents a Bank with list of accounts
public class Bank {
    
    String name;
    ILoA accounts;
    
    public Bank(String name){
        this.name = name;

        // Each bank starts with no accounts
        this.accounts = new MtLoA();
    }

    public void openAccount(Account other){
        this.accounts = new ConsLoA(other, this.accounts);
    }
    
    public void deposit(int account, int amount){
        this.accounts.deposit(account, amount);
    }
    
    public void removeAccount(int account){
        this.accounts = this.accounts.removeAccount(account);
    }
}
