import java.util.*;

class Dish {
    String name, type;
    List<String> tags;

    Dish(String name, String type, List<String> tags) {
        this.name = name;
        this.type = type;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") → " + tags;
    }
}

public class SmartMenu {
    private List<Dish> menu = new ArrayList<>();
    private Set<String> dishNames = new HashSet<>();

    public void addDish(Dish dish) {
        if (dishNames.contains(dish.name.toLowerCase())) {
            System.out.println("Duplicate dish ignored: " + dish.name);
            return;
        }
        menu.add(dish);
        dishNames.add(dish.name.toLowerCase());
    }

    public void search(String keyword) {
        keyword = keyword.toLowerCase();
        for (Dish d : menu) {
            if (d.name.toLowerCase().contains(keyword) || d.tags.contains(keyword)) {
                System.out.println(d);
            }
        }
    }

    public static void main(String[] args) {
        SmartMenu menu = new SmartMenu();
        menu.addDish(new Dish("Paneer Butter Masala", "Main", Arrays.asList("spicy", "paneer")));
        menu.addDish(new Dish("Gulab Jamun", "Dessert", Arrays.asList("sweet")));
        menu.addDish(new Dish("Chili Paneer", "Starter", Arrays.asList("spicy", "paneer")));

        menu.search("paneer");
    }
}
