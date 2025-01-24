// Kendra Fitzgerald
// RegisterPanel.java

package makingchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// creating a panel that has the input fields and display for the calculator
public class RegisterPanel extends JPanel {
    private final Register register;
    private final JTextField input;
    private final PursePanel changePanel;


    // creating a new panel with an input field and change display
    public RegisterPanel() {
        this.register = new Register();
        this.input = new JTextField(10);
        this.changePanel = new PursePanel();
        setLayout(new BorderLayout());

        // creating input panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Amount: "));
        inputPanel.add(input);
        input.addActionListener(new InputListener());
        add(inputPanel, BorderLayout.NORTH);

        // creating change panel
        add(changePanel, BorderLayout.CENTER);

}

    // handling the input fields
    private class InputListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amount);
                changePanel.updatePurse(purse);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this,
                        "Invalid amount. Enter again");


            }
        }
    }
}