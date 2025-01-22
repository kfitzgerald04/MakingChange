// Kendra Fitzgerald
// PursePanel.java

package makingchange;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


// this panel displays the GUI representation of the money
public class PursePanel extends JPanel {
    private Purse purse;
    private final Map<String, Image> imageCache;
    private static final int IMAGE_WIDTH = 150;
    private static final int IMAGE_HEIGHT = 75;
    private static final int SPACING = 10;
    private String resultText;


    // creating a new panel to display the images
    public PursePanel() {
        this.purse = new Purse();
        this.imageCache = new HashMap<>();
        setBackground(Color.WHITE);
    }

    // updates the contents of the purse, and refreshes the GUI
    public void setPurse(Purse newPurse) {
        this.purse = newPurse;
        repaint();
    }


    // loads and caches the images, and returns them to the GUI
    private Image loadImage(String imageName) {
        if (!imageCache.containsKey(imageName)) {
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + imageName));
                Image scaled = icon.getImage().getScaledInstance(
                        IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
                imageCache.put(imageName, scaled);
            } catch (Exception e) {
                System.err.println("Error loading image: " + imageName);
                return null;
            }
        }
        return imageCache.get(imageName);
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (purse == null) return;

        int x = SPACING;
        int y = 40;

        Map<DDenomination, Integer> contents = purse.getmoney();
        for (Map.Entry<DDenomination, Integer> entry : contents.entrySet()) {
            DDenomination denom = entry.getKey();
            int count = entry.getValue();
            Image img = loadImage(denom.img());


            if (img != null && count > 0) {
                // stacking the money, with an offest for visualization purposes
                for (int i = 0; i < count; i++) {
                    g.drawImage(img, x, y + (i * 3), this);
                }

                // move to next position
                x += IMAGE_WIDTH + SPACING;
                if (x + IMAGE_WIDTH > getWidth()) {
                    x = SPACING;
                    y += IMAGE_HEIGHT + SPACING;
                }
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }
}