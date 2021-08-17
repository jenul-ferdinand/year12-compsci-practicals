import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

class MyCanvas extends JPanel 
{
	Court court;
	int left = 10;
	int right = 400;
	int top = 10;
	int bottom = 300;

	Ball ball1;
	int initBallSize = 40;
	// Start at the center of the court
	int initBallX = (right/2) - initBallSize;
	int initBallY = (bottom/2) - initBallSize;
	int initBallXSpeed = 2;
	int initBallYSpeed = 2;
	Color initBallColour = new Color(66, 120, 248);

	
	Timer timer1;
	int initialDelay = 10;
	int refreshRate = 10;
	
	public void init() {
		setSize(right+left,bottom+top);
		
		court = new Court(left, right, top, bottom);
		ball1 = new Ball(initBallX, initBallY, initBallXSpeed, initBallYSpeed, initBallSize, initBallColour);
		
		timer1 = new Timer();
		
		// initial delay and refresh rate are in milliseconds
		timer1.schedule(new AnimationTask(), initialDelay, refreshRate);
	}
	
	private class AnimationTask extends TimerTask {
		public void run() {
			ball1.move(court);
			repaint();
		}	
	}
	
	public void paint(Graphics g) {
		paintComponent(g);

		g.setColor(Color.black);
		court.draw(g);
		
		g.setColor(ball1.col);
		ball1.draw(g);
	}
}


public class OneBall {
	public static void main(String[] a) {
		MyCanvas myCanvas = new MyCanvas();
		myCanvas.init();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(20, 20, 620, 620);
		window.getContentPane().add(myCanvas);
		window.setVisible(true);
     }
}
