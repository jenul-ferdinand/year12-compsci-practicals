import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Task0 extends JPanel implements ActionListener {
    Button submitButton;
    Label prompt;
    TextField inputField;

    int number = 0;

    public void init() {
        prompt = new Label ("Please Enter Multiplication Value:");
        inputField = new TextField(15);
        submitButton = new Button("Submit");

        add(prompt);
        add(inputField);
        add(submitButton);

        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        number = Integer.parseInt(inputField.getText());

        repaint();
    }

    public void paint (Graphics g) {
        paintComponent(g);

        // Doubles
        int start = 80;
        int ypos = start;
        for (int i = 2; i <= 20; i += 2) {
            g.drawString("" + i, 20, ypos);

            ypos += 20;
        }

        // Blast Off
        ypos = start;
        for (int i = 10; i >= 0; i--) {
            if (i > 0) {
                g.drawString("" + i, 60, ypos);
            }
            else {
                g.drawString("Blast Off!", 60, ypos);
            }

            ypos += 20;
        }

        // Groups
        ypos = start;
        for (int i = 10; i <= 50; i += 10) {
            g.drawString("Group: " + i, 100, ypos);

            ypos += 20;
        }

        // Multiplication Table
        ypos = start;
        for (int i = 1; i <= 12; i++) {

            int multAnswer = i * number;

            g.drawString(i + " * " + number + " = " + multAnswer, 180, ypos);

            ypos += 20;
        }
    }
}

public class FourLoopsTask1 {
    public static void main(String[] a) {
        Task0 myCanvas = new Task0();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 400);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
