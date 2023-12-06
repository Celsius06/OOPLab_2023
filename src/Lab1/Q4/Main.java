package Q4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID for the order: ");
        int orderId = sc.nextInt();
        Order order = new Order(orderId);

        System.out.print("Enter the quantity of items: ");
        int numberItem = sc.nextInt();

        int i = 0;
        while (i < numberItem) {
            System.out.print("Enter the ID, Name, and Price to order " + (i + 1) + ": ");
            int itemId = sc.nextInt();
            String itemName = sc.next();
            double itemPrice = sc.nextDouble();

            Item item = new Item(itemId, itemName, itemPrice);
            int initialSize = order.getItems().size();
            order.addItem(item);
            if (order.getItems().size() > initialSize) {
                i++;
            }
        }

        double averageCost = order.calculateAverageCost();

        System.out.println("The Average Cost of the items in the order is: " + averageCost);

        sc.close();
    }
}
