package Q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side1 of the triangle: ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter side2 of the triangle: ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter side3 of the triangle: ");
        double side3 = scanner.nextDouble();

        Triangle triangle = new Triangle(side1, side2, side3);
        System.out.println("The type of the triangle is: " + triangle.verify());

        scanner.close();
    }
}
