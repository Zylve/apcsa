public class SavingsAccount {
    private double balance;
    private double interest;
    
    public SavingsAccount() {

    }

    public SavingsAccount(double balance, double interest) {
        this.balance = balance;
        this.interest = interest;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getInterest() {
        return this.interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void addInterest() {
        balance += balance * interest;
    }
}
