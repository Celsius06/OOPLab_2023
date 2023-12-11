package Q1;
import java.awt.Graphics;

public class MyLine extends MyShape {
    int x1, y1, x2, y2;

    MyLine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public String toString() {
        return "Line [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyLine other = (MyLine) obj;
        if (x1 != other.x1)
            return false;
        if (y1 != other.y1)
            return false;
        if (x2 != other.x2)
            return false;
        if (y2 != other.y2)
            return false;
        return true;
    }
}