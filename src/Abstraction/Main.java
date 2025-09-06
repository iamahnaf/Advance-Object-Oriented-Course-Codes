package Abstraction;

public class Main {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.deposit(100);
        savingAccount.display();
        savingAccount.withdraw(25.6);
        savingAccount.display();
    }
}
