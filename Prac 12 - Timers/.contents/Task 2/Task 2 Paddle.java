import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Paddle
{
    private int x, y, size;

    public Paddle(int x, int y, int size)
    {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void setCoordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void draw(Graphics g)
    {
        g.fillRect(x, y, size, size);
    }

    public boolean intersects(Ball b)
    {
        Rectangle r = new Rectangle (x,y,size,size);
        Ellipse2D.Double e = new Ellipse2D.Double(b.getX(),b.getY(),b.getSize(),b.getSize());

        if (e.intersects(r))
            return true;
        else
            return false;
    }
}
