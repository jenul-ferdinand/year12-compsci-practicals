import javax.swing.*;
import java.awt.*;

class Task2 extends JPanel {
    int[] a = {6, 7, 9, 12, 4};
    int total, ypos;

    public void paint(Graphics g) {
        total = 0;
        ypos = 20;

        for (int i = 0; i < a.length; i++) {
            total = total + a[i];

            g.drawString("" + a[i], 20, ypos);
            g.drawString("" + total, 120, ypos);
            ypos = ypos + 20;
        }

        g.drawString("Total: " + total, 20, ypos + 30);
    }
}

public class Task2RunningTotal {
    public static void main(String[] args) {
        Task2 myCanvas = new Task2();
        //myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 400, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
