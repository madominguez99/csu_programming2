package module2;

public class BankAccount {
    private double balance;

    // Start with initial balance
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdraw money
    public void withdraw(double amount) {
        balance -= amount;
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }
}
