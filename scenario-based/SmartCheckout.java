import java.util.*;

class Customer {
    String name;
    List<String> items;

    Customer(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }
}

public class SmartCheckout {
    private Queue<Customer> queue = new LinkedList<>();
    private Map<String, Integer> prices = new HashMap<>();
    private Map<String, Integer> stock = new HashMap<>();

    public void addCustomer(Customer customer) {
        queue.add(customer);
        System.out.println("Customer added: " + customer.name);
    }

    public void processCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in queue.");
            return;
        }

        Customer current = queue.poll();
        System.out.println("Processing: " + current.name);
        int total = 0;
        for (String item : current.items) {
            if (stock.getOrDefault(item, 0) > 0) {
                total += prices.getOrDefault(item, 0);
                stock.put(item, stock.get(item) - 1);
            } else {
                System.out.println("Out of stock: " + item);
            }
        }
        System.out.println("Total Bill: ₹" + total);
    }

    public void setPriceAndStock(String item, int price, int stockQty) {
        prices.put(item, price);
        stock.put(item, stockQty);
    }

    public static void main(String[] args) {
        SmartCheckout checkout = new SmartCheckout();
        checkout.setPriceAndStock("Milk", 50, 10);
        checkout.setPriceAndStock("Bread", 30, 5);

        checkout.addCustomer(new Customer("Alice", Arrays.asList("Milk", "Bread")));
        checkout.addCustomer(new Customer("Bob", Arrays.asList("Bread", "Milk", "Milk")));
        checkout.processCustomer();
        checkout.processCustomer();
        checkout.processCustomer();
    }
}
