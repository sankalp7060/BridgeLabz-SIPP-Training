import java.util.*;

// Attendee class with constructor overloading
class Attendee {
    String name;
    int age;
    String email;

    public Attendee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Attendee(String name, int age, String email) {
        this(name, age);
        this.email = email;
    }
}

// Main
public class TicketingSystem {
    public static void main(String[] args) {
        HashMap<String, Queue<Attendee>> eventMap = new HashMap<>();

        // Add event and queue
        eventMap.put("Concert", new LinkedList<>());

        // Add attendees
        Queue<Attendee> concertQueue = eventMap.get("Concert");
        concertQueue.add(new Attendee("John", 25));
        concertQueue.add(new Attendee("Alice", 22, "alice@example.com"));
        concertQueue.add(new Attendee("Bob", 30));

        // Get position
        String searchName = "Alice";
        int position = 1;
        boolean found = false;

        for (Attendee attendee : concertQueue) {
            if (attendee.name.equalsIgnoreCase(searchName)) {
                System.out.println(searchName + " is at position " + position + " in the Concert queue.");
                found = true;
                break;
            }
            position++;
        }

        if (!found) {
            System.out.println(searchName + " not found in the Concert queue.");
        }
    }
}
