package Q3;

public class Point { // 2 attributes of a point
    private double x;
    private double y;

    public Point(double x, double y) {     // Take the input from the user
        this.x = x;
        this.y = y;
    }

    public double distance(Point target) {
        return Math.sqrt(Math.pow(this.x - target.x, 2) + Math.pow(this.y - target.y, 2));
    }
}
