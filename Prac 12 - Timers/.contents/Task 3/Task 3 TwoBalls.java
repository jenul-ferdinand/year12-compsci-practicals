import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

class MyCanvas extends JPanel implements MouseListener, MouseMotionListener {
	Court court;
	int left = 10;
	int right = 400;
	int top = 10;
	int bottom = 300;

	Ball ball1;
	Ball ball2;
	int initBallSize = 40;
	// Start at the center of the court
	int initBallX = (right/2) - initBallSize;
	int initBallY = (bottom/2) - initBallSize;
	int initBallXSpeed = 2;
	int initBallYSpeed = 2;
	Color initBallColour = new Color(66, 120, 248);

	Paddle paddle;
	int initPaddleX = 100;
	int initPaddleY = 100;
	int initPaddleSize = 20;

	Timer timer1;
	Timer timer2;
	int initialDelay = 10;
	int refreshRate = 10;
	
	public void init() {
		setSize(right+left,bottom+top);
		
		court = new Court(left, right, top, bottom);
		ball1 = new Ball(initBallX, initBallY, initBallXSpeed, initBallYSpeed, initBallSize, initBallColour);
		ball2 = new Ball(initBallX, initBallY, initBallXSpeed, initBallYSpeed, initBallSize, initBallColour);
		
		timer1 = new Timer();
		timer2 = new Timer();

		paddle = new Paddle(initPaddleX, initPaddleY, initPaddleSize);
		addMouseListener(this);
		addMouseMotionListener(this);

		// initial delay and refresh rate are in milliseconds
		timer1.schedule(new AnimationTask1(), initialDelay, refreshRate);
		timer2.schedule(new AnimationTask2(), initialDelay, refreshRate);
	}
	
	private class AnimationTask1 extends TimerTask {
		public void run() {
			ball1.move(court);
			repaint();
		}	
	}
	private class AnimationTask2 extends TimerTask {
		public void run() {
			ball2.move(court);
			repaint();
		}
	}

	public void paint(Graphics g) {
		paintComponent(g);

		g.setColor(Color.red);
		paddle.draw(g);

		g.setColor(Color.black);
		court.draw(g);
		
		g.setColor(ball1.col);
		ball1.draw(g);

		g.setColor(ball2.col);
		ball2.draw(g);
	}

	// Mouse events
	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		paddle.setCoordinates(e.getX(),e.getY());
		repaint();
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		paddle.setCoordinates(e.getX(),e.getY());

		if (paddle.intersects(ball1))
		{
			System.out.println("Hit Ball 1");
			timer1.cancel();
			timer1.purge();
		}

		if (paddle.intersects(ball2))
		{
			System.out.println("Hit Ball 2");
			timer2.cancel();
			timer2.purge();
		}

		repaint();
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
}

public class TwoBalls {
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
