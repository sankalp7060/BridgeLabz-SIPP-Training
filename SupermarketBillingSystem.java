import java.util.*;
class CartItem {
    String itemName;
    int quantity;
    double pricePerUnit;

    public CartItem(String itemName, int quantity, double pricePerUnit) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public double getTotal() {
        return quantity * pricePerUnit;
    }
}

class ShoppingCart<T extends CartItem> {
    Map<String, T> cart = new HashMap<>();

    public void addItem(T item) {
        cart.putIfAbsent(item.itemName, item);
    }

    public double getTotalCost() {
        double total = 0;
        for (T item : cart.values()) {
            total += item.getTotal();
        }
        return total;
    }
}

public class SupermarketBillingSystem {
    public static void main(String[] args) {
        ShoppingCart<CartItem> cart = new ShoppingCart<>();
        cart.addItem(new CartItem("Milk", 2, 25.5));
        cart.addItem(new CartItem("Bread", 1, 30.0));

        System.out.println("Total: Rs. " + cart.getTotalCost());
    }
}