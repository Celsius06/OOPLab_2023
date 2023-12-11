package Q2;
public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1 = new MyPoint(x1, y1);
        this.v2 = new MyPoint(x2, y2);
        this.v3 = new MyPoint(x3, y3);
    }

    public double[] getEdges() {
        double[] edges = new double[3];
        edges[0] = Math.round(v1.distance(v2) * 100.0) / 100.0;
        edges[1] = Math.round(v2.distance(v3) * 100.0) / 100.0;
        edges[2] = Math.round(v3.distance(v1) * 100.0) / 100.0;
        return edges;
    }

    public String getType() {
        double[] edges = getEdges();

        if (edges[0] == edges[1] && edges[1] == edges[2]) {
            return "Equilateral";
        } else if (edges[0] == edges[1] || edges[1] == edges[2] || edges[0] == edges[2]) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
}