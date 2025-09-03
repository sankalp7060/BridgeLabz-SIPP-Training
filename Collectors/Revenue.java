import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
    String customer;
    double amount;

    Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }
    public String getCustomer() { return customer; }
    public double getAmount() { return amount; }
}

public class Revenue {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Alice", 250.0),
            new Order("Bob", 300.0),
            new Order("Alice", 150.0),
            new Order("Charlie", 400.0)
        );

        Map<String, Double> revenue = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,
                        Collectors.summingDouble(Order::getAmount)));

        System.out.println(revenue);
    }
}
