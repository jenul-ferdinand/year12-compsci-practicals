import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Task2 extends JPanel implements ActionListener {
    double principal;
    double rate;
    double time;

    Label principalLabel;
    Label rateLabel;
    Label timeLabel;

    TextField principalField;
    TextField rateField;
    TextField timeField;

    Button submitButton;

    public void init () {
        principalLabel = new Label("Enter your initial amount:");
        rateLabel = new Label("Enter your p/a interest rate:");
        timeLabel = new Label("Number of years:");

        principalField = new TextField(10);
        rateField = new TextField(10);
        timeField = new TextField(10);

        submitButton = new Button("Submit");

        add(principalLabel);
        add(principalField);
        add(rateLabel);
        add(rateField);
        add(timeLabel);
        add(timeField);

        add(submitButton);

        submitButton.addActionListener(this);
    }

    public void actionPerformed (ActionEvent e) {
        principal = Double.parseDouble(principalField.getText());
        rate = Double.parseDouble(rateField.getText());
        time = Double.parseDouble(timeField.getText());

        repaint();
    }

    public void paint (Graphics g) {
        paintComponent(g);

        int startYPos = 110;
        int buffer = 20;
        g.drawString("Year: ", 100, startYPos);
        g.drawString("Amount: ", 200, startYPos);

        int ypos = startYPos + buffer;
        for (int i = 1; i <= time; i++) {
            g.drawString("" + i, 100, ypos);

            double amount = simpleInterest(principal, rate, i);
            double round2Decimal = (double) Math.round(amount * 100) / 100;
            g.drawString("$" + round2Decimal, 200, ypos);
            ypos += buffer;
        }
    }

    // Simple interest calculation method
    static double simpleInterest (double principal, double rate, double time) {
        return principal * Math.pow(1.0 + rate / 100.0, time);
    }
}

public class MiracleOfCompoundInterestTask3 {
    public static void main(String[] a) {
        Task2 myCanvas = new Task2();
        myCanvas.init();
        JFrame window = new JFrame("Compound Interest Calculator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 600);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
