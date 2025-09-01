package module1;

import java.util.Scanner;

public class TestBankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CheckingAccount acct = new CheckingAccount();
        acct.setFirstName("Michelle");
        acct.setLastName("Dominguez");
        acct.setAccountID(12345);
        acct.setInterestRate(0.1150); 

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt(sc);

            switch (choice) {
                case 1: // Deposit
                    System.out.print("Enter deposit amount: ");
                    double dep = readDouble(sc);
                    acct.deposit(dep);
                    break;

                case 2: // Withdraw
                    System.out.print("Enter withdrawal amount: ");
                    double w = readDouble(sc);
                    acct.processWithdrawal(w);
                    break;

                case 3: // Print balance
                    System.out.printf("Current balance: $%.2f%n", acct.getBalance());
                    break;

                case 4: // Print account summary
                    acct.accountSummary();
                    break;

                case 5: // Exit
                    running = false;
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Please choose 1–5.");
            }
            System.out.println();
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1) Deposit");
        System.out.println("2) Withdraw");
        System.out.println("3) Print balance");
        System.out.println("4) Print account summary");
        System.out.println("5) Exit");
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a whole number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    private static double readDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Please enter a number (e.g. 25 or 25.50): ");
            sc.next();
        }
        double val = sc.nextDouble();
        sc.nextLine();
        return val;
    }
}
