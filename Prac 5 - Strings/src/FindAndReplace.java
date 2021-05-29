import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;

class MyCanvas2 extends JPanel implements ActionListener {
    TextField findTextField;
    String find;

    TextField replaceTextField;
    String replace;

    Button replaceButton;
    TextArea defaultTextArea;
    TextArea outputTextArea;

    String defaultText;
    String outputText;

    public void init() {
        replaceButton = new Button("Replace");

        defaultTextArea = new TextArea("",15,30,TextArea.SCROLLBARS_VERTICAL_ONLY);
        defaultTextArea.setEditable(false);

        outputTextArea = new TextArea("",15,30,TextArea.SCROLLBARS_VERTICAL_ONLY);
        outputTextArea.setEditable(false);

        findTextField = new TextField(30);
        replaceTextField = new TextField(30);

        add(new Label("FIND AND REPLACE"));

        add(defaultTextArea);

        add(new Label("Find: "));
        add(findTextField);

        add(new Label("Replace: "));
        add(replaceTextField);

        add(replaceButton);
        add(outputTextArea);

        replaceButton.addActionListener(this);

        defaultText = "And he was a miserable wicked creature, and already he had a plan. Not far away was his island, of which Bilbo knew nothing, and there in his hiding-place he kept a few wretched oddments, and one very beautiful thing, very beautiful, very wonderful. He had a ring, a golden ring, a precious ring.\n" + "\n" + "\"My birthday-present!\" he whispered to himself, as he had often done in the endless dark days. \"That's what we wants now, yes; we wants it!\" He wanted it because it was a ring of power, and if you slipped that ring on your finger, you were invisible; only in the full sunlight could you be seen, and then only by your shadow, and that would be shaky and faint. \"My birthday-present! It came to me on my birthday, my precious,\" So he had always said to himself. But who knows how Gollum came by that present, ages ago in the old days when such rings were still at large in the world?\n";
        defaultTextArea.setText(defaultText);
    }

    public void actionPerformed(ActionEvent e) {
        find = findTextField.getText();
        find = find.trim();

        replace = replaceTextField.getText();
        replace = replace.trim();

        outputText = defaultText.replaceAll(find, replace);
        outputTextArea.setText(outputText);

        // Throw error message if text fields are empty
        if (find.isEmpty() || replace.isEmpty()) { JOptionPane.showMessageDialog(null, "Please enter text", "Error", JOptionPane.ERROR_MESSAGE); }
    }
}

public class FindAndReplace {
    public static void main(String[] a) {
        MyCanvas2 myCanvas = new MyCanvas2();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 400, 700);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
