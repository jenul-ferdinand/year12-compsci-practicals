import java.awt.*;
import javax.swing.*;
class DemoCanvas extends JPanel 
{
	public void paint(Graphics g) 
	{
		g.setFont(new Font("sans serif", Font.BOLD, 30));
		g.setColor(new Color(224, 224, 224));
		g.drawString("HELLO WORLD",10,30);
		
		g.setColor(new Color(224, 224, 224));	
		g.drawRect(40,60,100,100);
		
		g.setColor(new Color(224, 224, 224));		
		g.drawOval(10,50,90,90);		
	}
}

public class PaintDemo 
{
	public static void main(String[] a) 
	{

		Color bgColor = new Color (36, 36, 36);
		
		DemoCanvas myCanvas = new DemoCanvas();
		
		JFrame window = new JFrame();
		window.setBackground(bgColor);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 300, 300);
		window.getContentPane().add(myCanvas);
		window.setVisible(true);
	}
}
