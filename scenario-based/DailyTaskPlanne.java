import java.util.LinkedList;
import java.util.Scanner;

// Abstract Task class
abstract class Task {
    String title;

    Task(String title) {
        this.title = title;
    }

    abstract void execute();
}

// Subclasses
class Meeting extends Task {
    Meeting(String title) {
        super(title);
    }

    void execute() {
        System.out.println("Meeting task: " + title);
    }
}

class Workout extends Task {
    Workout(String title) {
        super(title);
    }

    void execute() {
        System.out.println("Workout task: " + title);
    }
}

class CodingSession extends Task {
    CodingSession(String title) {
        super(title);
    }

    void execute() {
        System.out.println("Coding session task: " + title);
    }
}

// Main
public class DailyTaskPlanner {
    public static void main(String[] args) {
        LinkedList<Task> tasks = new LinkedList<>();
        tasks.add(new Meeting("Team Sync"));
        tasks.add(new Workout("Morning Yoga"));
        tasks.add(new CodingSession("Fix bug #123"));

        System.out.println("Executing tasks:");
        for (Task task : tasks) {
            task.execute();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nSearch task by keyword: ");
        String keyword = scanner.nextLine();

        boolean found = false;
        for (Task task : tasks) {
            if (task.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found: " + task.title);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching task found.");
        }
    }
}
