import java.awt.Graphics;

public class Court {
    private int left, right, top, bottom;
    private int courtWidth, courtHeight;

    public Court(int left, int right, int top, int bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;

        courtWidth = this.right-this.left;
        courtHeight = this.bottom-this.top;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public void draw(Graphics g) {
        g.drawRect(left, top, courtWidth, courtHeight);
    }
}
