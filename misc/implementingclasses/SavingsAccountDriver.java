public class SavingsAccountDriver {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(200, 0.05);

        savingsAccount.deposit(20);
        savingsAccount.withdraw(15);
        savingsAccount.deposit(35);

        System.out.println(savingsAccount.getBalance());

        savingsAccount.withdraw(25);
        savingsAccount.deposit(320);
        savingsAccount.withdraw(30);

        System.out.println(savingsAccount.getBalance());
        savingsAccount.addInterest();
        System.out.println(savingsAccount.getBalance());
    }
}
