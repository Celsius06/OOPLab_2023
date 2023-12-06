package Q1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle[] rectangles = new Rectangle[5];
        for (int i = 0; i < rectangles.length; i++) {
            System.out.print("Enter width for rectangle " + (i + 1) + ": ");
            int width = sc.nextInt();
            System.out.print("Enter length for rectangle " + (i + 1) + ": ");
            int height = sc.nextInt();
            rectangles[i] = new Rectangle(width, height);
        }
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("Rectangle " + (i + 1) + ":");
            visualizeRectangle(rectangles[i]);
            System.out.println();
        }
        sc.close();
    }

    private static void visualizeRectangle(Rectangle rect) {
        for (int row = 0; row < rect.getHeight(); row++) {  
            for (int col = 0; col < rect.getWidth(); col++) {  
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
