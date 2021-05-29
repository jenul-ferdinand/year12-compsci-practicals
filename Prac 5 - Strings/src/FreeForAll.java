import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;

/*
[NAME] has been reported dead from [DEATH]. Unfortunately it turns out that [NAME] had [NAME LENGTH]000 of a valuable
crypto currency called [FUNNY WORD]-Coin.
 */

class MyCanvas1 extends JPanel implements ActionListener {
    // Initialise
    TextField nameTextField;
    String fullName;

    TextField sillyTextField;
    String silly;

    Button generateButton;
    TextArea outputTextArea;

    String output;

    // Excuses
    String[] randomDeaths = {
            "fell to his death",
            "eating too much",
            "not being able to get of his couch",
            "procrastination",
    };

    public void init() {
        // Buttons and textfields
        generateButton = new Button("Generate");

        outputTextArea = new TextArea("",15,30,TextArea.SCROLLBARS_VERTICAL_ONLY);
        outputTextArea.setEditable(false);

        nameTextField = new TextField(30);
        sillyTextField = new TextField(30);

        add(new Label("Funny"));
        add(new Label("Enter your name: "));
        add(nameTextField);

        add(new Label("Enter a silly word: "));
        add(sillyTextField);

        add(generateButton);
        add(outputTextArea);

        generateButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        fullName = nameTextField.getText();
        fullName = fullName.trim();

        silly = sillyTextField.getText();
        silly = silly.trim();

        output = "";

        output += fullName.substring(0, 1).toUpperCase() + fullName.substring(1) + " has been reported dead from " + randomDeaths[(int) (Math.random()*randomDeaths.length)] + ".";
        output += " Unfortunately it turns out that ";
        output += fullName.substring(0, 1).toUpperCase() + fullName.substring(1) + " had " + fullName.length() + "000 of a valuable crypto currency called " + silly.substring(0, 1).toUpperCase() + silly.substring(1) + "-Coin.";

        outputTextArea.setText(output);
    }
}

public class FreeForAll {
    public static void main(String[] a) {
        MyCanvas1 myCanvas = new MyCanvas1();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 600);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
