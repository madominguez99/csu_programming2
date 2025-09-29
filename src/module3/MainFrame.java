package module3;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainFrame extends JFrame {
    private JTextArea textArea;
    private JPanel mainPanel;
    private JMenuItem changeColorItem;

    public MainFrame() {
        setTitle("Option #1: User Interface I");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with padding 
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        setContentPane(mainPanel);

        // Text area
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(textArea);
        mainPanel.add(scroll, BorderLayout.CENTER);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        JMenuItem dateTimeItem   = new JMenuItem("Show Date/Time");
        JMenuItem saveFileItem   = new JMenuItem("Save to log.txt");
        changeColorItem          = new JMenuItem("Random Green Hue");
        JMenuItem exitItem       = new JMenuItem("Exit");

        menu.add(dateTimeItem);
        menu.add(saveFileItem);
        menu.add(changeColorItem);
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Actions
        dateTimeItem.addActionListener(e -> showDateTime());
        saveFileItem.addActionListener(e -> saveToFile());
        changeColorItem.addActionListener(e -> changeBackgroundColor());
        exitItem.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void showDateTime() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = LocalDateTime.now().format(fmt);
        textArea.append("Current Date/Time: " + dateTime + System.lineSeparator());
    }

    private void saveToFile() {
        String content = textArea.getText();
        Utils.writeToFile("log.txt", content);
        JOptionPane.showMessageDialog(this, "Saved to log.txt");
    }

    private void changeBackgroundColor() {
        // Pick a fresh random green each click
        Color greenHue = Utils.randomGreenHSB();
        String hex = Utils.colorToHex(greenHue);

        // Apply the color to the frame + panel
        getContentPane().setBackground(greenHue);
        mainPanel.setBackground(greenHue);

        // Update menu item so user sees which green was chosen
        changeColorItem.setText("Random Green Hue (" + hex + ")");

        // Log to text area
        textArea.append("Changed to new green hue: " + hex + System.lineSeparator());
    }
}
