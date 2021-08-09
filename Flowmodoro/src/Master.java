import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyCanvas extends JPanel implements ActionListener {
    long start = -1;
    long timeNow = 0;
    boolean startTimer = false;

    Button mainButton;
    String mainButtonText = "Start";

    public void init() {
        // Create the button
        mainButton = new Button(mainButtonText);

        // Add the button
        add(mainButton);

        // Add the action listener
        mainButton.addActionListener(this);
    }

    public void paint(Graphics g) {
        paintComponent(g);

        if (start == -1) {
            timeNow = 0;
        } else {
            timeNow = (System.currentTimeMillis() - start)/1000;
        }

        // Setting the label of the main button
        mainButton.setLabel(mainButtonText);

        // Drawing the time
        g.drawString("" + timeNow, 20, 20);

        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        // Stop or start timer
        startTimer = !startTimer;

        // Checking
        if (startTimer) { mainButtonText = "Stop"; } else { mainButtonText = "Start"; }

        // State the start time, for calculation later
        start = System.currentTimeMillis();
    }
}

public class Master {
    public static void main(String[] args) {
        MyCanvas myCanvas = new MyCanvas();                     // Reference the canvas class to myCanvas
        myCanvas.init();                                        // Call the init method
        JFrame frame = new JFrame();                            // Reference the JFrame class to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Default closing operation
        frame.setBounds(30, 30, 400, 300);      // width and height and the x and y of window
        frame.getContentPane().add(myCanvas);                   // Get the frame and add the canvas class
        frame.setVisible(true);                                 // Make the window visible
    }
}
