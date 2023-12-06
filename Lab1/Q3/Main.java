package Q3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Point 1
        System.out.print("Enter x-coordinate for Point 1: ");
        double x1 = scanner.nextDouble();

        System.out.print("Enter y-coordinate for Point 1: ");
        double y1 = scanner.nextDouble();

        Point point1 = new Point(x1, y1);

        // Input for Point 2
        System.out.print("Enter x-coordinate for Point 2: ");
        double x2 = scanner.nextDouble();

        System.out.print("Enter y-coordinate for Point 2: ");
        double y2 = scanner.nextDouble();

        Point point2 = new Point(x2, y2);

        // Print the distance
        System.out.println("Distance between point1 and point2: " + point1.distance(point2));

        scanner.close();
    }
}
