import javax.swing.*;

class Task4 extends JPanel {

}

public class Task4BubbleSortIntegers {
    public static void main(String[] args) {
        Task3 myCanvas = new Task3();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 400, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
