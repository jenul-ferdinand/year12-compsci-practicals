import java.awt.*;
import javax.swing.*;

class MyCanvas extends JPanel {
    // 4 test scores for 3 students
    int[][] results = {
        {10, 30, 82, 49},
        {88, 25, 72, 56},
        {30, 52, 37, 49},
    };

    int total = 0; // Total of all the scores

    int xPos,yPos;
    int startX = 40;
    int startY = 40;
    int lastX = 150;
    int col = 1;

    public void paint(Graphics g) {
        paintComponent(g);

        // Display contents of the 2D array
        xPos = startX;
        yPos = startY;

        for (int row = 0; row < results.length; row++) {
            for (int column = 0; column < results[0].length; column++) {
                g.drawString("" + results[row][column], xPos, yPos);
                xPos += 30;

                total += results[row][column];


            }

            // Draw the student number
            g.drawString("" + col++, startX - 20, yPos);
            // Draw the row totals
            g.drawString("" + total, lastX + 10, yPos);


            // Draw vertical seperators
            g.drawLine(startX - 5, startY-15, startX - 5, startY-15 + 65);
            g.drawLine(lastX, startY-15, lastX, startY-15 + 65);
            // Draw horizontal seperator
            g.drawLine(startX - 5, startY-15, startX - 5 + 115, startY-15);

            // Draw the headings
            g.drawString("Student", startX - 20, startY - 17);
            g.drawString("Scores", startX + 30, startY - 17);
            g.drawString("Totals", startX + 120, startY - 17);


            yPos += 20;
            xPos = startX;
        }

        g.drawString("Total of scores: " + total, xPos + 10, yPos + 10);
    }
}


public class Task1TotalScore {
    public static void main(String[] a) {
        MyCanvas myCanvas = new MyCanvas();
        // myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 400, 300);
        window.getContentPane().add(myCanvas);
        window.setResizable(false);
        window.setVisible(true);
    }
}
