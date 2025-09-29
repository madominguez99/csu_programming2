package module3;

import javax.swing.SwingUtilities;

public class Module3App {
    public static void main(String[] args) {
        // Launch Swing UI on the Event Dispatch Thread
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
