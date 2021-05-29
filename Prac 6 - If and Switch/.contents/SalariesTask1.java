import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Task1 extends JPanel implements ActionListener {
    Label rules;
    TextField inputField;
    Button submitButton;
    int hoursWorked = 0;
    int salaryRate = 0;

    public void init() {
        rules = new Label("Enter your hours worked: "); add(rules);
        inputField = new TextField(20); add(inputField);
        submitButton = new Button("Calculate Salary Rate"); add(submitButton);

        submitButton.addActionListener(this);
    }

    public void paint(Graphics g) {
        paintComponent(g);
        g.drawString("Salary: " + salaryRate, 20, 100);
    }

    public void actionPerformed(ActionEvent e) {
        hoursWorked = Integer.parseInt(inputField.getText());

        System.out.println("Hours Entered :" + hoursWorked);

        // Calculate salary here
        if (hoursWorked < 35) { salaryRate = 15; }
        else { salaryRate = 25; }
        System.out.println("Salary Calculation: " + salaryRate);

        repaint();
    }
}

public class SalariesTask1 {
    public static void main(String[] a) {
        Task1 myCanvas = new Task1();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
