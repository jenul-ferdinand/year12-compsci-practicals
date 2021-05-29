import java.awt.*;
import javax.swing.*;

class MyCanvas1 extends JPanel {
    double x, y, sum, difference, product, quotient, remainder;
    int i, j, int_sum, int_difference, int_product, int_quotient, int_remainder;

    public void init() {
        x = 25.0;
        y = 6.0;

        sum = x + y;
        difference = x - y;
        product = x * y;
        quotient = x / y;
        remainder = x % y;

        // Repeat the calculations, with our two values cast to integers
        i = (int) x;
        j = (int) y;

        int_sum = i + j;
        int_difference = i - j;
        int_product = i * j;
        int_quotient = i / j;
        int_remainder = i % j;
    }

    public void paint(Graphics g) {
        // Display the results
        g.drawString("As reals, the values are x: " + x + " and y: " + y, 20, 25);
        g.drawString("The sum, x + y = " + sum, 20, 50);
        g.drawString("The difference, x - y = " + difference, 20, 75);
        g.drawString("The product, x * y = " + product, 20, 100);
        g.drawString("The quotient, x / y = " + quotient, 20, 125);
        g.drawString("The remainder, x % y = " + remainder, 20, 150);

        g.drawString("As integers, these are i: " + i + " and j: " + j, 350, 25);
        g.drawString("The sum, i + j = " + int_sum, 350, 50);
        g.drawString("The difference, i - j = " + int_difference, 350, 75);
        g.drawString("The product, i * j = " + int_product, 350, 100);
        g.drawString("The quotient, i / j = " + int_quotient, 350, 125);
        g.drawString("The remainder, i % j = " + int_remainder, 350, 150);
    }
}

public class IntegersAndReals_Task1 {
    public static void main(String[] a) {
        MyCanvas1 myCanvas = new MyCanvas1();
        myCanvas.init();
        JFrame window1 = new JFrame();
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.setBounds(30, 30, 600, 300);
        window1.getContentPane().add(myCanvas);
        window1.setVisible(true);
    }
}
