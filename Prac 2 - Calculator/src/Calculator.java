import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NewCanvas extends JPanel implements ActionListener {
    TextField typeText, answerText;
    Button Button;

    public void init() {

    }

    public void paint(Graphics g) {
        paintComponent(g);

        repaint();
    }

    public void actionPerformed(ActionEvent e) {

    }
}

public class Calculator {
    public static void main(String[] a) {
        NewCanvas myCanvas = new NewCanvas();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
