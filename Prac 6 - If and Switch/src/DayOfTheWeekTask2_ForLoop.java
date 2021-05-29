import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

class Task2_1 extends JPanel implements ActionListener {
    TextField dayNumberField;
    Label prompt;
    Button submitButton;
    int dayNumber = 0;
    String dayName;

    List<String> dayNames = Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

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

        // Loop through all of the dayNames
        for (int i = 0; i < 6; i++) {
            if (dayNumber == i) dayName = dayNames.get(i);
        }

        repaint();
    }

    public void paint(Graphics g) {
        paintComponent(g);

        g.drawString("Day Name: " + dayName, 20, 200);

    }
}

public class DayOfTheWeekTask2_ForLoop {
    public static void main(String[] a) {
        Task2_1 myCanvas = new Task2_1();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
