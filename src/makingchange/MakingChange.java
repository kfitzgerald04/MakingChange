// Kendra Fitzgerald
// MakingChange.java

package makingchange;

import javax.swing.*;

// main class that displays the GUI
public class MakingChange {
    public static void main(String[] args) {
        // the next couple of a lines are for appearance, pulled these commands from online
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Making Change");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new RegisterPanel());
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}