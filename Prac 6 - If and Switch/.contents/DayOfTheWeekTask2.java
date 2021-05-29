import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Task2 extends JPanel implements ActionListener {
    TextField dayNumberField;
    Label prompt;
    Button submitButton;
    int dayNumber = 0;
    String dayName;

    public void init() {
        prompt = new Label("Enter your day number: ");
        dayNumberField = new TextField(10);
        submitButton = new Button("Submit");
        submitButton.addActionListener(this);

        add(prompt);
        add(dayNumberField);
        add(submitButton);

    }

    public void actionPerformed(ActionEvent e) {
        dayNumber = Integer.parseInt(dayNumberField.getText());

        if (dayNumber == 1) dayName = "Sunday";
        else if (dayNumber == 2) dayName = "Monday";
        else if (dayNumber == 3) dayName = "Tuesday";
        else if (dayNumber == 4) dayName = "Wednesday";
        else if (dayNumber == 5) dayName = "Thursday";
        else if (dayNumber == 6) dayName = "Friday";
        else if (dayNumber == 7) dayName = "Saturday";
        else dayName = "Invalid";

        repaint();
    }

    public void paint(Graphics g) {
        paintComponent(g);

        g.drawString("Day Name: " + dayName, 20, 200);

    }
}

public class DayOfTheWeekTask2 {
    public static void main(String[] a) {
        Task2 myCanvas = new Task2();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
