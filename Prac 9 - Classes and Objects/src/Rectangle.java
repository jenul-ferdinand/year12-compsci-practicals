import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
    // Constructor
    public Rectangle(String name, int x, int y, int width, int height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        colour = Color.BLUE;
        speed = 10;
    }

    // Method to Change size
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Get perimeter
    public int getPerimeter() {
        return 2 * (width + height);
    }

    // Get area
    public int getArea() {
        return width * height;
    }

    // Get name
    public String getName() {
        return name;
    }

    // Drawing
    public void draw(Graphics g) {
        g.setColor(colour);
        g.fillRect(x,y,width,height);
    }
}
