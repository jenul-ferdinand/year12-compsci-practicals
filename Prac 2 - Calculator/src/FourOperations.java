import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CalcCanvas extends JPanel implements ActionListener {
    Label myPrompt1, myPrompt2;
    TextField value1, value2;
    Button addButton, subtractButton, multiplyButton, divideButton;

    int totalAmount;
    int valueAmount1;
    int valueAmount2;

    public void init() {
        // Text prompts
        myPrompt1 = new Label("This class will add two numbers.");
        myPrompt2 = new Label("Type in the numbers in the spaces.");
        add(myPrompt1);
        add(myPrompt2);

        // Text fields and text listener
        value1 = new TextField(14);
        value1.setText("0");
        value2 = new TextField(14);
        value2.setText("0");
        add(value1);
        add(value2);

        // Buttons
        addButton = new Button("Add");
        subtractButton = new Button("Subtract");
        multiplyButton = new Button("Multiply");
        divideButton = new Button("Divide");
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
    }

    // If the text value has been changed
    public void actionPerformed(ActionEvent event) {
        valueAmount1 = Integer.parseInt(value1.getText());
        valueAmount2 = Integer.parseInt(value2.getText());

        if (event.getSource() == addButton) {
            totalAmount = valueAmount1 + valueAmount2;
        }

        if (event.getSource() == subtractButton) {
            totalAmount = valueAmount1 - valueAmount2;
        }

        if (event.getSource() == multiplyButton) {
            totalAmount = valueAmount1 * valueAmount2;
        }

        if (event.getSource() == divideButton) {
            totalAmount = valueAmount1 / valueAmount2;
        }
    }

    public void paint(Graphics graphic) {
        paintComponent(graphic);
        graphic.drawString("Added amount: " + totalAmount, 20, 150);
        repaint();
    }
}

public class FourOperations {
    public static void main(String[] a) {
        CalcCanvas myCanvas = new CalcCanvas();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
