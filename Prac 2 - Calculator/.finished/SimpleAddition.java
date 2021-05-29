import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

class MyCanvas extends JPanel implements TextListener {
    Label myPrompt1, myPrompt2;
    TextField value1, value2;

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
        value1 = new TextField(10);
        value1.addTextListener(this);
        value2 = new TextField(10);
        value2.addTextListener(this);
        add(value1);
        add(value2);

    }

    // If the text value has been changed
    public void textValueChanged(TextEvent event) {
        valueAmount1 = Integer.parseInt(value1.getText());
        valueAmount2 = Integer.parseInt(value2.getText());
        totalAmount = valueAmount1 + valueAmount2;
    }

    public void paint(Graphics graphic) {
        paintComponent(graphic);
        graphic.drawString("Added amount: " + totalAmount, 20, 150);
        repaint();
    }
}

public class SimpleAddition {
    public static void main(String[] a) {
        MyCanvas myCanvas = new MyCanvas();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
