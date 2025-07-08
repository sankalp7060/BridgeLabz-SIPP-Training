import java.util.*;

public class FoodLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<FoodItem> menu = Arrays.asList(
            new VegItem("Paneer Tikka", 180, 10),
            new VegItem("Veg Biryani", 150, 8),
            new VegItem("Masala Dosa", 90, 5),
            new NonVegItem("Chicken Biryani", 220, 7),
            new NonVegItem("Butter Chicken", 250, 6),
            new NonVegItem("Egg Curry", 160, 4)
        );

        Order order = new Order();

        System.out.println("Welcome to FoodLoop - Restaurant Ordering System!");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        while (true) {
            System.out.println("\n---- Menu ----");
            int index = 1;
            for (FoodItem item : menu) {
                System.out.println(index++ + ". " + item.getName() + " (" + item.getCategory() + ") :- " + item.getPrice()
                                   + " [" + (item.isAvailable() ? "Available" : "Out of Stock") + "]");
            }

            System.out.print("Enter item number to add to order (0 to finish): ");
            int choice = sc.nextInt();

            if (choice == 0) break;

            if (choice >= 1 && choice <= menu.size()) {
                order.addItem(menu.get(choice - 1));
            } else {
                System.out.println("Invalid choice.");
            }
        }

        order.printOrder();

        System.out.print("\nDo you want to place the order? (yes/no): ");
        sc.nextLine(); 
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            order.placeOrder();
        } else {
            order.cancelOrder();
        }

        sc.close();
    }
}
