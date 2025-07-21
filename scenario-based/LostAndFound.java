import java.util.*;

public class LostAndFound {
    private Map<String, LinkedList<String>> itemMap = new HashMap<>();
    private Set<String> allItems = new HashSet<>();

    public void addItem(String type, String description) {
        if (allItems.contains(description)) {
            System.out.println("Duplicate item ignored: " + description);
            return;
        }
        itemMap.putIfAbsent(type, new LinkedList<>());
        itemMap.get(type).add(description);
        allItems.add(description);
        System.out.println("Item added: [" + type + "] " + description);
    }

    public void searchItem(String type, String keyword) {
        if (!itemMap.containsKey(type)) {
            System.out.println("No items found for type: " + type);
            return;
        }

        LinkedList<String> list = itemMap.get(type);
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Match found at position " + i + ": " + list.get(i));
                found = true;
            }
        }

        if (!found) System.out.println("No match found.");
    }

    public static void main(String[] args) {
        LostAndFound desk = new LostAndFound();
        desk.addItem("bags", "Black Nike Bag");
        desk.addItem("mobiles", "Samsung Galaxy White");
        desk.addItem("books", "Java Programming Book");
        desk.addItem("bags", "Blue Adidas Backpack");

        desk.searchItem("bags", "blue"); // Linear search
    }
}
