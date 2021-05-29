import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ButtonCanvas extends JPanel implements ActionListener		
{ 
	Button clicker;												
	int count = 0;
	int addAmount = 1;
	
    Button upgrade;
	
    // Run once at the start
	public void init()
	{
		// Increase clicks button
		clicker = new Button("Press Here");  					
		add(clicker);								
		clicker.addActionListener(this);	
		
		// Upgrade clicker button
		upgrade = new Button("Upgrade Click");
		add(upgrade);
		upgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				upgradeClicker();
			}
		});
	}
	
	// Increase the amount the click is added by
	private void upgradeClicker() {
		addAmount++;
	}
	
	// Drawing on the screen
	public void paint(Graphics g)
	{
		paintComponent(g);
		g.drawString("Amount of clicks: "+ count, 20, 50);
		g.drawString("Click add amount: " + addAmount, 20, 70);
		repaint();
	}
	
	// When button pressed 
	public void actionPerformed(ActionEvent event) {
		count += addAmount;
	}
	
	
}	

public class ButtonClicker {
    public static void main(String[] a) {
        ButtonCanvas buttonCanvas = new ButtonCanvas();
        buttonCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(buttonCanvas);
        window.setVisible(true);
     }
}
