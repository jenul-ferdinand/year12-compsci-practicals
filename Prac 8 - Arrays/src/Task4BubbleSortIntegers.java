import javax.swing.*;
import java.awt.*;

class Task4 extends JPanel {
    int[] a = {8, 5, 64, 15, 2, 1, -3, 0, 42, 99};
    boolean finished = false;
    int i, j, xpos, hold;

    public void paint(Graphics g) {
        paintComponent(g);

        xpos = 20;
        for (i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                hold = a[i];
                a[i] = a[i+1];
                a[i+1] = hold;
            }

            g.drawString("" + a[i], xpos, 10);
            g.drawString("" + a[i +1], xpos, 30);

            xpos += 20;

            repaint();
        }

    }


}

public class Task4BubbleSortIntegers {
    public static void main(String[] args) {
        Task4 myCanvas = new Task4();
        //myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 400, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
