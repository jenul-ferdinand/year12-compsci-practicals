import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Drop {
    private int posx;
    private int posy;
    private int yspeed;
    private int xspeed;
    private int thick;
    private int length;

    private int width_rain_place;
    private int height_rain_place;

    public Drop(int width_rain_place, int height_rain_place) {
        this.width_rain_place = width_rain_place;
        this.height_rain_place = height_rain_place;

        Random rand = new Random();
        this.posx = rand.nextInt(this.width_rain_place);
        this.posy = rand.nextInt(450) - 500;
        this.yspeed = rand.nextInt(4) + 2;
        this.xspeed = 0;
        this.thick = rand.nextInt(4) + 1;
        this.length = rand.nextInt(9) + 5;
    }

    public void fall(java.awt.Graphics g) {
        this.yspeed += 0.05;
        this.posx += this.xspeed;
        this.posy += this.yspeed;

        // Reduce the drop
        if (this.posy > this.height_rain_place) {
            Random rand = new Random();
            this.posx = rand.nextInt(this.width_rain_place);
            this.posy = rand.nextInt(450) - 500;
            this.yspeed = rand.nextInt(4) + 2;
            this.xspeed = 0;
            this.thick = rand.nextInt(4) + 1;
            this.length = rand.nextInt(9) + 5;
        }

        g.setColor(new java.awt.Color(84, 98, 127));
        g.fillRect(this.posx, this.posy, this.thick, this.length);
    }
}

class HouseCanvas extends JPanel implements ActionListener {
    Timer tm = new Timer(5, this);
    Drop[] d = null;
    int drop_num = 2000;

    public HouseCanvas() {
        d = new Drop[this.drop_num];
        for (int i = 0; i < d.length; i++) {
            d[i] = new Drop(2000, 800);
        }
    }


    // Colours
    Color skyCol = new Color(75, 56, 101);
    Color cloudCol = new Color(85, 85, 85, 191);
    Color cloudCol2 = new Color(70, 70, 70, 174);
    Color sunBehindCol = new Color(203, 173, 156, 255);
    Color sunFrontCol = new Color(201, 190, 155);
    Color groundCol = new Color(105, 140, 106);

    // Sky method
    public void drawSky(int x, int y, int width, int height, Color colour, Graphics g) {
        g.setColor(colour);
        g.fillRect(x, y, width, height);
    }
    // House method
    public void drawHouse(int x, int y, Graphics g) {
        // Roof left side
        g.setColor(new Color(165, 102, 102));
        int[] xx = {x, x + 45, x + 70};
        int[] yy = {y, y - 30, y - 30};
        Polygon poly1 = new Polygon(xx, yy, 3);
        g.fillPolygon(poly1);
        int[] xz = {x + 45, x + 70, x};
        int[] yz = {y, y - 30, y};
        Polygon poly2 = new Polygon(xz, yz, 3);
        g.fillPolygon(poly2);
        // Roof front side
        g.setColor(new Color(145, 73, 73));
        int xs[] = {x + 20, x + 70, x + 120};
        int ys[] = {y, y - 30, y};
        Polygon poly = new Polygon(xs, ys, 3);
        g.fillPolygon(poly);

        // Drawing front of body
        g.setColor(new Color(48, 48, 48));
        g.fillRect(x, y, 120,  120);

        // Drawing left side of body
        g.setColor(new Color(84, 84, 84));
        g.fillRect(x, y, 20, 120);

        // Drawing door
        g.setColor(new Color(80, 54, 48, 255));
        g.fillRect(x + 55, y + 60, 30, 60);

        // Drawing left window
        g.setColor(new Color(78, 92, 104, 255));
        g.fillRect(x + 30, y + 25, 20, 20);
        // Drawing right window
        g.setColor(new Color(78, 92, 104, 255));
        g.fillRect(x + 90, y + 25, 20, 20);
    }
    // Cloud method
    public void drawCloud(int x, int y, int width, int height, Color colour, Color colour2, Graphics g) {
        Random rand = new Random();
        int upperbound = 60;
        int random = rand.nextInt(upperbound);
        g.setColor(colour2);
        g.fillOval(x, y, width, height);
        g.setColor(colour);
        g.fillOval(x+random, y+random, width, height);
        g.setColor(colour2);
        g.fillOval(x+20, y-random, width, height);
        g.setColor(colour);
        g.fillOval(x+30, y-random, width, height);
    }



    @Override
    public void paintComponent(Graphics g) {
        // Sky
        drawSky(0, 0, 800, 400, skyCol, g);

        // Sun
        g.setColor(sunBehindCol);
        g.fillOval(-50, -50, 200, 200);
        g.setColor(sunFrontCol);
        g.fillOval(-50, -50, 170, 170);

        // Clouds
        for (int i = 0; i < 15; i++) {
            drawCloud((50 * i) + 100, -10, 120, 120, cloudCol, cloudCol2, g);
            i++;
        }

        // Ground
        g.setColor(groundCol);
        g.fillRect(0, 350, 800, 500);

        // House
        drawHouse(250, 300, g);
    }

    public void paint(Graphics g) {
        paintComponent(g);
        for (int i = 0; i < d.length; i++) {
            d[i].fall(g);
        }
        tm.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }
}


public class HouseWithMethods {
    public static void main(String[] a) {
        HouseCanvas myCanvas = new HouseCanvas();
        //myCanvas.init();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 800, 500);
        window.getContentPane().add(myCanvas);
        window.setResizable(false);
        window.setVisible(true);
    }
}
