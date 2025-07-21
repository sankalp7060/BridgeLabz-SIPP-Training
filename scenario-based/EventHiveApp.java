// Ticket class
class Ticket {
    private int ticketId;
    private String userName;
    private static int counter = 1;

    public Ticket(String userName) {
        this.userName = userName;
        this.ticketId = counter++;
    }

    public void showTicket() {
        System.out.println("Ticket ID: " + ticketId + " | User: " + userName);
    }
}

// User class
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public Ticket registerForEvent() {
        System.out.println(name + " registered for the event.");
        return new Ticket(name);
    }
}

// EventManager interface
interface EventManager {
    void addEvent(String eventName);
    void removeEvent(String eventName);
}

// Admin class
class Admin implements EventManager {
    @Override
    public void addEvent(String eventName) {
        System.out.println("Event added: " + eventName);
    }

    @Override
    public void removeEvent(String eventName) {
        System.out.println("Event removed: " + eventName);
    }
}

// Main
public class EventHiveApp {
    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.addEvent("AI Workshop");

        User user = new User("Alice");
        Ticket ticket = user.registerForEvent();
        ticket.showTicket();

        admin.removeEvent("AI Workshop");
    }
}
