package Q4;
import java.util.ArrayList;

public class Order {
    private int id; 
    private ArrayList<Item> items;

    public Order(int id){ 
        this.id = id;
        this.items = new ArrayList<>();
    }

    public int getId(){ 
        return id;
    }

    public ArrayList<Item> getItems() { // Getters for items
        return items;
    }
    
    public void addItem(Item item){
        for (Item existingItem : items) {
            if (existingItem.getId() == item.getId()) {
                System.out.println("An item with ID " + item.getId() + " already exists in the order. Item not added.");
                return;
            }
        }
        items.add(item);
    }
    
    public double calculateAverageCost(){
        if(items.isEmpty()){
            return 0.0;
        }
        double totalCost = 0.0;
        for(Item item: items){
            totalCost += item.getPrice();
            }
        return totalCost / items.size();
    }     
}
