public class BankAccountDriver {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(Reference.OVERDRAFT_SMALL);

        bankAccount.deposit(1000);
        bankAccount.withdraw(500);
        System.out.println(bankAccount.getBalance());
        bankAccount.withdraw(750);
        System.out.println(bankAccount.getBalance());
        bankAccount.withdraw(500);
        System.out.println(bankAccount.getBalance());
        bankAccount.withdraw(250);
        System.out.println(bankAccount.getBalance());
        bankAccount.withdraw(1);
    }
}
