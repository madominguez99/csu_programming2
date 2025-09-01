package module1;

public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAccountID() { return accountID; }
    public void setAccountID(int accountID) { this.accountID = accountID; }

    public double getBalance() { return balance; }
    protected void setBalance(double newBalance) { this.balance = newBalance; }

    // Deposit 
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit must be a positive number.");
            return;
        }
        balance += amount;
        System.out.printf("Deposited: $%.2f%n", amount);
        System.out.printf("New balance: $%.2f%n", balance);
    }

    // Standard withdrawal, no overdraft
    public boolean withdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal must be a positive number.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds (standard withdrawal).");
            return false;
        }
        balance -= amount;
        System.out.printf("Withdrawal: $%.2f%n", amount);
        System.out.printf("Balance: $%.2f%n", balance);
        return true;
    }
}
