package Abstraction;

public abstract class Bank {
    void deposit(double amount) {}
    void withdraw(double amount) {}
}
class SavingAccount extends Bank {
    double amount;
    double bankBalance;

    @Override
    void deposit(double amount) {
        bankBalance += amount;
    }
    void withdraw(double amount) {
        bankBalance -= amount;
        System.out.println(amount+" Taka withdrawl done");
    }
    void display(){
        System.out.println("Bank Balance: " + bankBalance);
    }
}
