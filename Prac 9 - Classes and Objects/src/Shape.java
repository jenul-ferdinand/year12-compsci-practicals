import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class Shape {
    // Instantiate vars
    String name;
    int x, y, width, height;
    Color colour;
    int speed;

    // Constructor
    public Shape() {
    }

    // Method to Change size
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void setRandomColour() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        this.colour = new Color(r, g, b);

        // ONE LINER: new Color((int)(Math.random() * 0x1000000))
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Decrease Size
    public void decreaseSize(int amount) {
        this.width -= amount;
        this.height -= amount;
    }

    // Increase Size
    public void increaseSize(int amount) {
        this.width += amount;
        this.height += amount;
    }

    // Movement
    public void moveRight() {
        x += speed;
    }
    public void moveLeft() {
        x -= speed;
    }
    public void moveUp() {
        y -= speed;
    }
    public void moveDown() {
        y += speed;
    }

    // Get name
    public String getName() {
        return name;
    }
    // Get perimeter
    public int getPerimeter() {
        return 2 * (width + height);
    }
    // Get area
    public int getArea() {
        return width * height;
    }
    // Drawing
    abstract void draw(Graphics g);
}
