package module2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankApp extends JFrame implements ActionListener {
    private BankAccount account;   // the account object
    private JTextField inputField; // for entering amounts
    private JLabel balanceLabel;   // to display balance
    private JButton depositButton, withdrawButton;

    public BankApp() {
        // Ask user for initial balance
        String input = JOptionPane.showInputDialog("Enter initial balance:");
        double initialBalance = 0;
        try {
            initialBalance = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Starting balance set to $0.00.");
        }
        account = new BankAccount(initialBalance);

        // Set up GUI
        setTitle("Bank Balance App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));

        // Input field
        panel.add(new JLabel("Enter amount:"));
        inputField = new JTextField();
        panel.add(inputField);

        // Deposit button
        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        panel.add(depositButton);

        // Withdraw button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);
        panel.add(withdrawButton);

        // Balance display
        balanceLabel = new JLabel(String.format("Balance: $%.2f", account.getBalance()));
        panel.add(balanceLabel);

        add(panel);

        // Show final balance upon exit
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Final balance: $" + String.format("%.2f", account.getBalance()));
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(inputField.getText());

            if (e.getSource() == depositButton) {
                account.deposit(amount);
            } else if (e.getSource() == withdrawButton) {
                account.withdraw(amount); 
            }

            // Update balance label
            balanceLabel.setText(String.format("Balance: $%.2f", account.getBalance()));
            inputField.setText(""); // clear field after use
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        BankApp app = new BankApp();
        app.setVisible(true);
    }
}
