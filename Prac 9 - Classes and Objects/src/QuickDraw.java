import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MyCanvas extends JPanel implements KeyListener {
    // Instantiate vars
    Shape[] shapes;

    float xSpeed;
    float ySpeed;

    // Initial method call
    public void init() {
        xSpeed = 1f;
        ySpeed = 1f;

        shapes = new Shape[3];

        setFocusable(true);
        addKeyListener(this);

        shapes[0] = new Rectangle("Sarah", 50,100,20,40);
        shapes[1] = new Rectangle("Harry", 100,50,10,100);
        shapes[2] = new Circle("John", 170, 100, 20, 20);
    }

    public void paint(Graphics g) {
        paintComponent(g);

        shapes[2].x += xSpeed;
        shapes[2].y += ySpeed;

        if (shapes[2].x < 0 || shapes[2].x > 400) {
            xSpeed *= -1;
        }
        if (shapes[2].y < 0 || shapes[2].y > 300) {
            ySpeed *= -1;
        }

        // Display the perimeter of the rectangles
        g.drawString("Perimeter of r1: "+ shapes[0].getPerimeter(), 20, 20);
        g.drawString("Area of r1: " + shapes[0].getArea(), 20, 40);
        g.drawString("Perimeter of r2: " + shapes[1].getPerimeter(), 180, 20);
        g.drawString("Area of r2: " + shapes[1].getArea(), 180, 40);

        // Display the name of all the shapes above them
        g.drawString("" + shapes[0].getName(), shapes[0].x - (shapes[0].width/2), shapes[0].y-3);
        g.drawString("" + shapes[1].getName(), shapes[1].x - (shapes[1].width/2), shapes[1].y-3);
        g.drawString("" + shapes[2].getName(), shapes[2].x - (shapes[2].width/2), shapes[2].y-3);

        // Draw the objects
        shapes[0].draw(g);
        shapes[1].draw(g);
        shapes[2].draw(g);

        repaint();
    }

    // Movement checking
    public void keyPressed(KeyEvent e) {
        for (var i = 0; i < shapes.length; i++) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    shapes[i].moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    shapes[i].moveRight();
                    break;
                case KeyEvent.VK_UP:
                    shapes[i].moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    shapes[i].moveDown();
                    break;
                case KeyEvent.VK_SPACE:
                    shapes[i].setRandomColour();
                    break;
            }
        }

        // Repaint every move
        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

}

public class QuickDraw {

    public static void main(String[] a) {
        MyCanvas myCanvas = new MyCanvas();
        myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 400, 300);
        window.getContentPane().add(myCanvas);
        window.setVisible(true);
    }

}

