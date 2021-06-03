import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Task3 extends JPanel implements ActionListener {
    boolean found;
    int index = -1;
    int[] a = {6, 7, 9, 12, 4};
    Button refreshButton;

    // Set the value of the search item
    Random rand = new Random();
    int searchItem = rand.nextInt(10 - 1) + 1;


    public void init() {
        // Add the refresh button
        refreshButton = new Button("Refresh");
        add(refreshButton);
        refreshButton.addActionListener(this);
    }

    // Refresh button pressed
    public void actionPerformed(ActionEvent e) {
        // Randomise the search item value
        Random rand = new Random();
        searchItem = rand.nextInt(10 - 1) + 1;
        repaint();
    }

    public void paint(Graphics g)
    {
        paintComponent(g);
        found = false;

        // Loop through the array if we haven't found the number
        int i = 0;
        while ((i < a.length) && !found) {
            // If the number in the list is the same as the number we are looking for.
            if (a[i] == searchItem) {
                // Found is true
                found = true;

                // Set the index value to what the index in the array is
                index = i;
            }
            // If the number in the list isnt the same as the number we are looking for.
            else {
                // Increment
                i++;
            }
        }

        // Display the number that we are looking for in the array
        g.drawString("Looking for " + searchItem, 20, 20);
        // If the for loop finds the number
        if (found) {
            // Display that we found it with the index.
            g.drawString("Found " + searchItem + " At index " + (index+1), 20, 40);
        }
        // If the for loop doesn't find it
        else {
            // Display not found.
            g.drawString("Not found", 20, 40);
        }

        int max = a[0];
        int min = a[0];
        // Loop through the array of numbers
        for (int ii = 0; ii < a.length; ii++) {
            // Find the largest number in the list
            if (a[ii] > max) {
                // Set max equal to the largest number found.
                max = a[ii];
            }

            // Find the smallest number in the list
            if (a[ii] < min) {
                // Set the min equal to the smallest number found.
                min = a[ii];
            }
        }

        // Display the max value and the min value.
        g.drawString("Max value: " + max, 20, 60);
        g.drawString("Min value: " + min, 20, 80);
    }
}

// Setup the window.
public class Task3SearchArray {
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
