import java.awt.*;
import java.util.Random;

public class Ball {

    private int x, y, xSpeed, ySpeed, size;
    Color col;

    Random rand1 = new Random();
    Random rand2 = new Random();

    // Constructor
    public Ball(int x, int y, int xSpeed, int ySpeed, int size, Color col) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed * (rand1.nextInt(2) * 2) - 1;
        this.ySpeed = ySpeed * (rand2.nextInt(2) * 2) - 1;
        this.size = size;
        this.col = col;
    }

    // Set position function
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Return values
    public int getX() {
        return x;
    }

    public int getY() {
        return y;   
    }

    public void move(Court c) {

        // Move the ball 
        x += xSpeed;
        y += ySpeed;

        // Court collision checking
        if (x < c.getLeft() || x >= c.getRight() - size) {
            xSpeed *= -1;
        }
        if (y < c.getTop() || y >= c.getBottom() - size) {
            ySpeed *= -1;
        }
    }
    
    public void draw(Graphics g) {
        // Draw self
        g.fillOval(x, y, size, size);
    }

    public int getSize() {
        return size;
    }
}
