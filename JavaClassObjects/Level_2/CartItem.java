import java.util.*;

public class CartItem {
    private String itemName;
    private int price;
    private int quantity;
    private List<CartItem> cart = new ArrayList<>();

    public CartItem(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public CartItem() {
    }

    public void addItem(String name, int price, int quantity) {
        cart.add(new CartItem(name, price, quantity));
        System.out.println("Item '" + name + "' added to the cart.");
    }

    public void removeItem(String name) {
        boolean removed = false;
        for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);
            if (item.itemName.equalsIgnoreCase(name)) {
                cart.remove(i);
                System.out.println("Item '" + name + "' removed from the cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Item '" + name + "' not found in the cart.");
        }
    }

    public void displayCart() {
        int total = 0;
        System.out.println("\nCart Summary:");
        for (CartItem item : cart) {
            int itemTotal = item.price * item.quantity;
            System.out.println(item.itemName + " - ₹" + item.price + " x " + item.quantity + " = ₹" + itemTotal);
            total += itemTotal;
        }
        System.out.println("Total Cost: ₹" + total);
    }

    public static void main(String[] args) {
        CartItem cartManager = new CartItem();
        cartManager.addItem("Rice", 50, 2);
        cartManager.addItem("Sugar", 40, 1);
        cartManager.addItem("Milk", 30, 3);
        cartManager.displayCart();
        cartManager.removeItem("Sugar");
        cartManager.displayCart();
    }
}
