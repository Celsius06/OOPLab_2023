package Lab2;
import java.awt.Color;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the width: ");
        int Width = sc.nextInt();
        System.out.print("Enter the length: ");
        int Length = sc.nextInt();
        System.out.print("Enter the number of steps (n): ");
        int n = sc.nextInt();

        Box box = new Box(Width, Length); 

        // Add some particles to the box with different positions, directions, and colors
        box.addParticle(new Particle(100, 100, Direction.EAST, Color.RED, box));
        box.addParticle(new Particle(200, 200, Direction.SOUTH, Color.GREEN, box));
        box.addParticle(new Particle(100, 300, Direction.SOUTHEAST, Color.BLACK, box));
    
        box.visualize(n); 
        sc.close();
    }
}