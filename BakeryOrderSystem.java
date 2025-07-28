import java.util.*;
class Order {
    String itemName;
    int quantity;
    String category;

    public Order(String itemName, int quantity, String category) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.category = category;
    }
}

class BakeryQueue<T extends Order> {
    Queue<T> orders = new LinkedList<>();

    public void addOrder(T order) {
        orders.offer(order);
    }

    public T deliverOrder() {
        return orders.poll();
    }

    public List<T> filterByCategory(String category) {
        List<T> result = new ArrayList<>();
        for (T order : orders) {
            if (order.category.equalsIgnoreCase(category)) {
                result.add(order);
            }
        }
        return result;
    }
}

public class BakeryOrderSystem {
    public static void main(String[] args) {
        BakeryQueue<Order> bakery = new BakeryQueue<>();
        bakery.addOrder(new Order("Chocolate Cake", 1, "Cake"));
        bakery.addOrder(new Order("Choco Chip", 3, "Cookie"));

        System.out.println("Delivered: " + bakery.deliverOrder().itemName);
        List<Order> cookies = bakery.filterByCategory("Cookie");
        for (Order o : cookies) {
            System.out.println(o.itemName);
        }
    }
}