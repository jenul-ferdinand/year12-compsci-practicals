import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyCanvas extends JPanel implements MouseListener {
    Image image;
    Graphics2D graphics2D;
    int x, y;

    public void init() {
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D)image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }

        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setColor(Color.black);

        repaint();
    }

    public void mousePressed(MouseEvent e) {
        clear();
        x = e.getX();
        y = e.getY();
        graphics2D.drawString("Mouse is at (" + x + "," + y + ")", x, y);
        repaint();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("The mouse has entered.");
    }

    public void mouseExited(MouseEvent e) {
    }

}

public class Task1 {
    public static void main(String[] args) {
        JFrame window = new JFrame("Mouse Demo");
        window.setLayout(new BorderLayout());

        // Create and add the sketch area to the window
        MyCanvas sketchArea = new MyCanvas();
        sketchArea.init();
        window.add(sketchArea, BorderLayout.CENTER);

        // Create and add a button to the window
        JPanel panel = new JPanel();
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sketchArea.clear();
            }
        });
        panel.add(clearButton);
        window.add(panel, BorderLayout.SOUTH);

        // Finish setting up the window
        window.setSize(280, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}

