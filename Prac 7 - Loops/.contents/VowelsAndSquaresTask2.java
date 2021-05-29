import javax.swing.*;
import java.awt.*;
import java.lang.Math;

class Task1 extends JPanel {
    public void paint(Graphics g) {
        paintComponent(g);

        int buffer = 20;
        int ypos = buffer;
        for(char ch = 'a'; ch <= 'z'; ch++) {
            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    g.drawString("Vowel", 40, ypos);
                    break;

                default:
                    g.drawString("" + ch, 40, ypos);
                    break;
            }

            ypos += buffer;
        }

        ypos = buffer;
        for (int i = 1; i <= 25; i++) {
            switch (i) {
                case 4:
                case 9:
                case 16:
                case 25:
                    g.drawString("" + i + " is " + Math.sqrt(i) + " squared.", 120, ypos);
                    break;

                default:
                    g.drawString("" + i, 120, ypos);
                    break;
            }

            ypos += buffer;
        }

        repaint();
    }


}

public class VowelsAndSquaresTask2 {
    public static void main(String[] a) {
        Task1 myCanvas = new Task1();
        //myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 600);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}