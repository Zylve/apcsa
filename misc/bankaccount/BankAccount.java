public class BankAccount {
    private double balance;
    private int overDraftProtection;

    public BankAccount() {
        this.balance = 0;
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public BankAccount(int overDraftProtection) {
        this.overDraftProtection = overDraftProtection;
    }

    public BankAccount(double balance, int overDraftProtection) {
        this.balance = balance;
        this.overDraftProtection = overDraftProtection;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if(this.balance - amount < 0) {
            if(this.balance - amount + this.overDraftProtection < 0) {
                System.out.println("Insufficient funds");

                return;
            }
        }

        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getOverDraftProtection() {
        return this.overDraftProtection;
    }

    public void setOverDraftProtection(int overDraftProtection) {
        this.overDraftProtection = overDraftProtection;
    }
}
