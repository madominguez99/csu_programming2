package module1;

public class CheckingAccount extends BankAccount {
    private double interestRate;

    public CheckingAccount() {
        super();
        this.interestRate = 0.115; // 11.5% interest rate
    }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

 // Withdrawl that allows for overdrafting ($30 fee and interest will be applied
    public void processWithdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal must be a  positive number.");
            return;
        }

        final double OVERDRAFT_FEE = 30.0;
        double current = getBalance();

        if (amount <= current) {
            setBalance(current - amount);
            System.out.printf("Withdrawal: $%.2f%n", amount);
            System.out.printf("Balance: $%.2f%n", getBalance());
        } else {
            double baseAfterFee = current - amount - OVERDRAFT_FEE; 
            double interestCharge = baseAfterFee * interestRate;  
            double newBalance = baseAfterFee + interestCharge;

            setBalance(newBalance);

            System.out.printf("Withdrawal: $%.2f%n", amount);
            System.out.printf("Overdraft fee: $%.2f%n", OVERDRAFT_FEE);
            System.out.printf("Interest: $%.2f%n", Math.abs(interestCharge));
            System.out.printf("Balance: $%.2f%n", getBalance());
        }
    }

    public void accountSummary() {
        System.out.println("----- Account Summary -----");
        System.out.println("Account ID: " + getAccountID());
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.printf("Balance: $%.2f%n", getBalance());
        System.out.printf("Interest Rate: %.2f%%%n", interestRate * 100);
        System.out.println("---------------------------");
    }
}
