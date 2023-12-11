package Q1;
import java.awt.Graphics;
public class MyOval extends MyShape {
    private int x, y, width, height;

    public MyOval(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(x, y, width, height);
    }

    public double getArea() {
        return Math.PI * width/2 * height/2;
    }

    @Override
    public String toString() {
        return "Oval [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyOval other = (MyOval) obj;
        if (height != other.height)
            return false;
        if (width != other.width)
            return false;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}