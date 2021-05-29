import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonCanvas extends JPanel implements ActionListener
{
    Button clicker;
    int count = 0;
    int addAmount = 1;

    Button upgrade;
    int upgradeCost = 10;

    // Current time when program started
    long startTime = 0;

    // Run once at the start
    public void init()
    {
        startTime = System.currentTimeMillis()/1000;
        System.out.println(startTime);

        // Increase clicks button
        clicker = new Button("Press Here");
        add(clicker);
        clicker.addActionListener(this);

        // Upgrade clicker button
        upgrade = new Button("Upgrade Click");
        add(upgrade);
        upgrade.addActionListener(this);
    }

    // Drawing on the screen
    public void paint(Graphics graphic)
    {
        paintComponent(graphic);
        // Info
        graphic.drawString("Amount of clicks: "+ count, 20, 50);
        graphic.drawString("Click add amount: " + addAmount, 20, 70);
        graphic.drawString("Cost of upgrade: " + upgradeCost, 20, 90);
        // Shows the clicks per second
        if (startTime != 0 && count != 0) graphic.drawString("Clicks per second: " + count/(System.currentTimeMillis()/1000 - startTime), 20, 110);
        else graphic.drawString("Clicks per second: 0", 20, 110);
        repaint();
    }

    // When button pressed
    public void actionPerformed(ActionEvent event) {
        // If the event was upgrade button
        if (event.getSource() == upgrade) {
            if (count >= upgradeCost) {
                // Increase addition amount
                addAmount++;
                // Subtract count by upgradeCost
                count -= upgradeCost;
                // Increase the price of the upgrade
                upgradeCost += 10;
            }
        }
        // If the even was not the upgrade button
        else {
            // Increase the count by the addition amount
            count += addAmount;
        }
    }
}

public class ButtonClicker {
    public static void main(String[] a) {
        ButtonCanvas buttonCanvas = new ButtonCanvas();
        buttonCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(buttonCanvas);
        window.setVisible(true);
    }
}
