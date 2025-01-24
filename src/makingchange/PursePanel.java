// Kendra Fitzgerald
// PursePanel.java

package makingchange;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;


// this panel displays the GUI representation of the money
public class PursePanel extends JPanel {
    private Purse purse;

    // constructor: creates an empty purse
    public PursePanel() {
        this.purse = new Purse();

    }

    // updates the contents of the purse, and refreshes the GUI
    public void updatePurse(Purse newPurse) {
        this.purse = newPurse;
        repaint(); // refresh panel
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10;
        int y = 10;

        for (Map.Entry<DDenomination, Integer> entry : purse.getmoney().entrySet()) {
            DDenomination denomination = entry.getKey();
            int count = entry.getValue();

            try {
                // load the image for the denomination
                Image img = ImageIO.read(new File("src/images/" + denomination.img()));
                g.drawImage(img, x, y, 100, 100, this);

                // drawing the denomination name and count
                g.drawString(count + " x " + denomination.name(), x, y + 120);
                x += 150; // increasing the spacing
                if (x > getWidth() - 150) {
                    x = 10;
                    y += 200;
                }
            } catch (IOException e) {
                g.drawString("Image not found for " + denomination.name(), x, y + 20);



            }

        }
    }
}