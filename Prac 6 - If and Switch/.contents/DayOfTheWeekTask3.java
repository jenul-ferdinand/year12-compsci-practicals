import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Task3 extends JPanel implements ActionListener {
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

        switch (dayNumber % 7) {
            case 1: dayName = "Sunday"; break;
            case 2: dayName = "Monday"; break;
            case 3: dayName = "Tuesday"; break;
            case 4: dayName = "Wednesday"; break;
            case 5: dayName = "Thursday"; break;
            case 6: dayName = "Friday"; break;
            case 0: dayName = "Saturday"; break;
            default: dayName = "Invalid"; break;
        }

        repaint();
    }

    public void paint(Graphics g) {
        paintComponent(g);

        g.drawString("Day Name: " + dayName, 20, 200);

    }
}

public class DayOfTheWeekTask3 {
    public static void main(String[] a) {
        Task3 myCanvas = new Task3();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
