import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

class MyCanvas4 extends JPanel implements ActionListener {
    double x, y, arithmetic1, arithmetic2, arithmetic3, arithmetic4, arithmetic5, arithmetic6, arithmetic7;
    int i, j, intArithmetic1, intArithmetic2, intArithmetic3, intArithmetic4, intArithmetic5;

    TextField inputX;
    TextField inputY;
    Button calculate;
    DecimalFormat decimalPlace2;
    DecimalFormat decimalPlace4;

    public void init() {
        // Init variables
        x = 0.0;
        y = 0.0;

        // Decimal formats
        decimalPlace2 = new DecimalFormat("#0.00");
        decimalPlace4 = new DecimalFormat("#0.0000");

        // Debug start program
        System.out.println("Start Program");

        // TextFields
        inputX = new TextField(10);
        inputY = new TextField(10);
        add(inputX);
        add(inputY);

        // Buttons
        calculate = new Button("Calculate");
        calculate.addActionListener(this);
        add(calculate);
    }

    public void actionPerformed(ActionEvent e) {
        x = Double.parseDouble(inputX.getText());
        y = Double.parseDouble(inputY.getText());

        arithmetic1 = (x + y) / (x - y);
        arithmetic2 = x + (x / y);
        arithmetic3 = x / (y + x);
        arithmetic4 = (x + y) * (x - y);
        arithmetic5 = (x / y) + x;
        arithmetic6 = x * y;
        arithmetic7 = x / y;

        // Repeat the calculations, with our two values cast to integers
        i = (int) x;
        j = (int) y;

        intArithmetic1 = (i + j) / (i - j);
        intArithmetic2 = i + (i / j);
        intArithmetic3 = i / (j + i);
        intArithmetic4 = (i + j) * (i - j);
        intArithmetic5 = (i / j) + i;

        // Debug
        System.out.println("Pressed Calculate");
        System.out.println("Value x: " + x);
        System.out.println("Value y: " + y);
    }

    public void paint(Graphics g) {
        paintComponent(g);

        // Display the results
        g.drawString("As reals, the values are x: " + x + " and y: " + y, 20, 50);
        g.drawString("(x+y)/(x-y) = " + decimalPlace2.format(arithmetic1), 20, 75);
        g.drawString("x+(x/y) =" + decimalPlace2.format(arithmetic2), 20, 100);
        g.drawString("x/(y+x) =" + decimalPlace2.format(arithmetic3), 20, 125);
        g.drawString("(x+y)*(x-y) = " + decimalPlace2.format(arithmetic4), 20, 150);
        g.drawString("(x/y)+x = " + decimalPlace2.format(arithmetic5), 20, 175);
        g.drawString("x*y = " + decimalPlace2.format(arithmetic6), 20, 200);
        g.drawString("x*y = " + decimalPlace4.format(arithmetic6), 20, 225);
        g.drawString("x/y = " + decimalPlace2.format(arithmetic7), 170, 200);
        g.drawString("x/y = " + decimalPlace4.format(arithmetic7), 170, 225);

        g.drawString("As integers, these are i: " + i + " and j: " + j, 350, 50);
        g.drawString("(i+j)/(i-j) = " + intArithmetic1, 350, 75);
        g.drawString("i+(i/j) = " + intArithmetic2, 350, 100);
        g.drawString("i/(j+i) = " + intArithmetic3, 350, 125);
        g.drawString("(i+j)*(i-j) = " + intArithmetic4, 350, 150);
        g.drawString("(i/j)+i = " + intArithmetic5, 350, 175);

        repaint();
    }
}

public class IntegersAndReals_Task4 {
    public static void main(String[] a) {
        MyCanvas4 myCanvas = new MyCanvas4();
        myCanvas.init();
        JFrame window4 = new JFrame();
        window4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window4.setBounds(30, 30, 600, 300);
        window4.getContentPane().add(myCanvas);
        window4.setVisible(true);
    }
}
