package Q2;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the coordinates for the first point (x1 - y1): ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.print("Enter the coordinates for the second point (x2 - y2): ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        System.out.print("Enter the coordinates for the third point (x3 - y3): ");
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        MyTriangle triangle = new MyTriangle(x1, y1, x2, y2, x3, y3);
        double[] edges = triangle.getEdges();
        System.out.println("The lengths of the edges are " + edges[0] + ", " + edges[1] + ", and " + edges[2]);
        System.out.print("The triangle is " + triangle.getType());
        scanner.close();
    }
}