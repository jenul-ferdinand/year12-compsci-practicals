import javax.swing.*;
import java.awt.*;

class MyCanvas extends JPanel {

    Employee mikeSmith;
    Employee sophieJones;

    double payRise = 1.03;

    public void init() {
        mikeSmith = new Employee("Mike Smith", 35, "Business Manager", 90000.00);
        sophieJones = new Employee("Sophie Jones", 37, "Vice President of Marketing", 110000.00);

        mikeSmith.employeeSalary(90000.00 * payRise);
        sophieJones.employeeSalary(110000.00 * payRise);
    }

    public void paint(Graphics g) {
        paintComponent(g); // Required function to stop the elements from overlapping.

        g.drawString("Mike's Salary: " + mikeSmith.getEmployeeRole(), 10, 10);
        g.drawString("Sophie's Salary: " + sophieJones.getEmployeeRole(), 10, 30);

        repaint(); // Function to keep running this method every time
    }
}

public class Experiment {
    public static void main(String[] args) {
        MyCanvas myCanvas = new MyCanvas();                     // Reference the canvas class to myCanvas
        myCanvas.init();                                        // Call the init method
        JFrame frame = new JFrame();                            // Reference the JFrame class to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Default closing operation
        frame.setBounds(30, 30, 400, 300);                      // width and height and the x and y of window
        frame.getContentPane().add(myCanvas);                   // Get the frame and add the canvas class
        frame.setVisible(true);                                 // Make the window visible
    }
}
