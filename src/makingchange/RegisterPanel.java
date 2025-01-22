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
        this.setLayout(new BorderLayout(10, 10));

        // input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        input = new JTextField(15);
        input.addActionListener(new InputListener());

        inputPanel.add(new JLabel("Enter Amount: $"));
        inputPanel.add(input);

        // change display panel
        changePanel = new PursePanel();
        changePanel.setBorder(BorderFactory.createTitledBorder("Change"));

        // add it all together
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(changePanel, BorderLayout.CENTER);
    }


    // handling the input fields
    private class InputListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amount);
                changePanel.setPurse(purse);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this,
                        "Please enter a valid amount",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}