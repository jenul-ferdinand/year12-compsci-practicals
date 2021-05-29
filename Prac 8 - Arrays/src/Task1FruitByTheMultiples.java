import java.awt.*;
import javax.swing.*;

class Task1 extends JPanel {
    // Instantiate the variables
    String[] shoppingList = {"Bread", "Milk", "Butter", "Eggs", "Cheese", "Bandaids"};
    int[] sixTimes = new int[10];
    int yPos;
    int xPos;

    public void init() {
        // Calculate six times table, until max length.
        for (int i = 0; i < sixTimes.length; i++) {
            sixTimes[i] = 6 * (i + 1);
        }
    }

    public void paint(Graphics g) {
        // Refresh the screen.
        paintComponent(g);

        // Horizontally display the shopping list items.
        xPos = 20;
        for (int i = 0; i < shoppingList.length; i++) {
            String str = i + ": " + shoppingList[i] + ",";
            int width = g.getFontMetrics().stringWidth(str);
            g.drawString(str, xPos, 20);
            xPos += width + 10;
        }

        // Vertically display the six times table.
        yPos = 60;
        for (int i = 0; i < sixTimes.length; i++) {
            g.drawString((i + 1) + " x 6 = " + sixTimes[i], 20, yPos);
            yPos += 20;
        }
    }
}

// Create the applet.
public class Task1FruitByTheMultiples {
    public static void main(String[] a) {
        Task1 myCanvas = new Task1();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 400, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
