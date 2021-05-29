import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.time.LocalTime;
import java.time.ZoneId;

class Task4 extends JPanel implements ActionListener {
    // 8:45 AM = 31500 Seconds
    // 12:10 PM = 43800 Seconds

    int secondsOfDay = LocalTime.now(ZoneId.of("Australia/Sydney")).toSecondOfDay();
    LocalTime timeOfDay = LocalTime.ofSecondOfDay(secondsOfDay);
    String time = timeOfDay.toString();

    Label timeLabel;

    public void init() {
        timeLabel = new Label(time);
        add(timeLabel);
    }

    public void paint(Graphics g) {
        if (secondsOfDay < 31500) {
            g.drawString("I can't wait for computer science.", 20, 70);
        }
        else if (secondsOfDay > 31500 && secondsOfDay < 43800) {
            g.drawString("It's time for computer science, yay!", 20, 70);
        }
        else if (secondsOfDay > 43800) {
            g.drawString("Computer science is over for the day, so sad.", 20, 70);
        }
    }

    public void actionPerformed(ActionEvent e) {

    }
}

public class TimeForClassTask4 {
    public static void main(String[] a) {
        Task4 myCanvas = new Task4();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }
}
