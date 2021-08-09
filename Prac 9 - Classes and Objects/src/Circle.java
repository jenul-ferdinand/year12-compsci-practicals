import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

    // Constructor
    public Circle(String name, int x, int y, int width, int height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        colour = Color.ORANGE;
        speed = 10;
    }

    // Method to Change size
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Drawing
    public void draw(Graphics g) {
        g.setColor(colour);
        g.fillOval(x, y, width, height);
    }
}