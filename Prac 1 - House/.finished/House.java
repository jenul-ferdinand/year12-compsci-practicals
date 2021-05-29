import java.awt.*;
import javax.swing.*;

class HouseCanvas extends JPanel
{

	public void paint(Graphics g)
	{
		// draw the sky
		g.setColor(new Color (126, 150, 230));
		g.fillRect(0, 0, 400, 300);
		
		// Draw the roof
		g.setColor(new Color (145, 73, 73));
		int xs[] = { 100, 160, 220 };
		int ys[] = { 100, 50, 100 };
		Polygon poly = new Polygon(xs, ys, 3);
		g.fillPolygon(poly);
		
		// draw the ground
		g.setColor(new Color (105, 140, 106));
		g.fillRect(0, 190, 400, 300);

		// Draw the body of house
		g.setColor(new Color (48, 48, 48));
		g.fillRect(100, 100, 120, 120);
		
		// draw the left side of the house
		g.setColor(new Color (84, 84, 84)); 
		g.fillRect(100, 100, 25, 120);

		// draw the door
		g.setColor(Color.white);
		g.fillRect(155, 160, 30, 60);
		
		// draw the right window
		g.setColor(Color.white);
		g.fillRect(130, 125, 20, 20); 
		
		// draw the right window
		g.setColor(Color.white);
		g.fillRect(190, 125, 20, 20); 

		// draw sun
		g.setColor(new Color (250, 234, 157));
		g.fillOval(240, 30, 50, 50);

		// draw chimney
		g.setColor(Color.black);
		g.fillRect(120, 55, 10, 30);
		
		
	}
}

public class House
{
	public static void main(String[] a)
	{
		HouseCanvas myCanvas = new HouseCanvas();
		//myCanvas.init();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 400, 300);
		window.getContentPane().add(myCanvas);
		window.setVisible(true);
	}
}
