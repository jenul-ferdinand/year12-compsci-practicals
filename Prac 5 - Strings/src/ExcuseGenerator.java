import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyCanvas extends JPanel implements ActionListener {
    // Initialise
    TextField nameTextField;
    String fullName, firstName, lastName;

    TextField conditionTextField, verbTextField, sillyTextField;
    String condition, verb, silly;

    Button generateButton;
    TextArea outputTextArea;

    String output;

    // Excuses
    String[] randomExcuses = {
            "A dog ate my homework. ",
            "I don't remember getting any homework! ",
            "I'm sorry I left it at home. ",
            "I didn't understand how to do it. " + "Could you explain it to me, and let me hand it in tomorrow? ",
            "My computer crashed before I'd saved it. ",
            "I lost my USB stick. ",
            "I stayed at a friend's house last night, " + "so wasn't able to pick it up this morning. ",
            "I wasn't here when you handed it out, so didn't know about it. ",
            "I had to do an extra shift at work last night. "
    };

    public void init() {
        // Buttons and textfields
        generateButton = new Button("Generate excuse");

        outputTextArea = new TextArea("",15,30,TextArea.SCROLLBARS_VERTICAL_ONLY);
        outputTextArea.setEditable(false);

        nameTextField = new TextField(30);
        conditionTextField = new TextField(30);
        verbTextField = new TextField(30);
        sillyTextField = new TextField(30);

        add(new Label("HOMEWORK EXCUSE GENERATOR"));
        add(new Label("Enter your full name: "));
        add(nameTextField);

        add(new Label("Enter a medical condition: "));
        add(conditionTextField);

        add(new Label("Enter a verb (e.g. run, hop): "));
        add(verbTextField);

        add(new Label("Enter a silly word: "));
        add(sillyTextField);

        add(generateButton);
        add(outputTextArea);

        generateButton.addActionListener(this);
    }

    public void paint(Graphics g)
    {
    }

    public void actionPerformed(ActionEvent e) {
        fullName = nameTextField.getText();
        fullName = fullName.trim();

        condition = conditionTextField.getText();
        condition = condition.toLowerCase();
        condition = condition.trim();

        verb = verbTextField.getText();
        verb = verb.trim();

        silly = sillyTextField.getText();
        silly = silly.trim();

        // Split full name into first and last name
        if (!fullName.isEmpty()) {
            int n = fullName.indexOf(" ");
            if (n == -1) {
                firstName = fullName;
                lastName = fullName;
            }
            else {
                firstName = fullName.substring(0, n);
                lastName = fullName.substring(n+1, fullName.length());
            }

            // Uppercase the first letter of the string
            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
            lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        }

        output = "";

        output += "I'm sorry, I don't have anything to hand in. ";

        output += randomExcuses[(int) (Math.random()*randomExcuses.length)];

        output += "Furthermore, I have been suffering from " + condition + ". ";

        output += "It's a rare form known as " + lastName + "'s " + silly + ". ";

        output += "It causes victims to " + verb + " uncontrollably, "
                + "but usually passes within " + fullName.length() + " days. ";

        output += "\n\n" + "Yours sincerely, \n" + firstName;

        outputTextArea.setText(output);

    }
}

public class ExcuseGenerator {
    public static void main(String[] a) {
        MyCanvas myCanvas = new MyCanvas();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 600);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
