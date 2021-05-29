import java.awt.*;
import javax.swing.*;

class MyCanvas2 extends JPanel {
    double x, y, arithmetic1, arithmetic2, arithmetic3, arithmetic4, arithmetic5;
    int i, j, intArithmetic1, intArithmetic2, intArithmetic3, intArithmetic4, intArithmetic5;

    public void init() {
        x = 25.0;
        y = 6.0;

        arithmetic1 = (x+y)/(x-y);
        arithmetic2 = x+(x/y);
        arithmetic3 = x/(y+x);
        arithmetic4 = (x+y)*(x-y);
        arithmetic5 = (x/y)+x;

        // Repeat the calculations, with our two values cast to integers
        i = (int) x;
        j = (int) y;

        intArithmetic1 = (i+j)/(i-j);
        intArithmetic2 = i+(i/j);
        intArithmetic3 = i/(j+i);
        intArithmetic4 = (i+j)*(i-j);
        intArithmetic5 = (i/j)+i;
    }

    public void paint(Graphics g) {
        // Display the results
        g.drawString("As reals, the values are x: " + x + " and y: " + y, 20, 25);
        g.drawString("(x+y)/(x-y) = " + arithmetic1, 20, 50);
        g.drawString("x+(x/y) =" + arithmetic2, 20, 75);
        g.drawString("x/(y+x) =" + arithmetic3, 20, 100);
        g.drawString("(x+y)*(x-y) = " + arithmetic4, 20, 125);
        g.drawString("(x/y)+x = " + arithmetic5, 20, 150);

        g.drawString("As integers, these are i: " + i + " and j: " + j, 350, 25);
        g.drawString("(i+j)/(i-j) = " + intArithmetic1, 350, 50);
        g.drawString("i+(i/j) = " + intArithmetic2, 350, 75);
        g.drawString("i/(j+i) = " + intArithmetic3, 350, 100);
        g.drawString("(i+j)*(i-j) = " + intArithmetic4, 350, 125);
        g.drawString("(i/j)+i = " + intArithmetic5, 350, 150);
    }
}

public class IntegersAndReals_Task2 {
    public static void main(String[] a) {
        MyCanvas2 myCanvas = new MyCanvas2();
        myCanvas.init();
        JFrame window2 = new JFrame();
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window2.setBounds(30, 30, 600, 300);
        window2.getContentPane().add(myCanvas);
        window2.setVisible(true);
    }
}
