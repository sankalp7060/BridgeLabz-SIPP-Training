import java.util.*;

public class Order implements IOrderable {
    private List<FoodItem> items = new ArrayList<>();
    private boolean isPlaced = false;
    private boolean isCancelled = false;

    public void addItem(FoodItem item) {
        if (item.isAvailable()) {
            items.add(item);
            item.reduceStock();
        } else {
            System.out.println(item.getName() + " is out of stock!");
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (FoodItem item : items) {
            total += item.getPrice();
        }
        return applyDiscount(total);
    }

    public double applyDiscount(double total) {
        if (total >= 500) {
            return total * 0.9; // 10% discount
        } else if (total >= 200) {
            return total * 0.95; // 5% discount
        }
        return total;
    }

    @Override
    public void placeOrder() {
        if (!items.isEmpty()) {
            isPlaced = true;
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Order is empty. Add items before placing.");
        }
    }

    @Override
    public void cancelOrder() {
        if (!isCancelled && isPlaced) {
            isCancelled = true;
            System.out.println("Order cancelled.");
        } else if (!isPlaced) {
            System.out.println("Order not yet placed.");
        } else {
            System.out.println("Order already cancelled.");
        }
    }

    public void printOrder() {
        if (items.isEmpty()) {
            System.out.println("No items in order.");
            return;
        }

        System.out.println("\nOrder Summary:");
        for (FoodItem item : items) {
            System.out.println(item.getName() + " - ₹" + item.getPrice());
        }
        System.out.println("Total (after discount): ₹" + calculateTotal());
    }
}
