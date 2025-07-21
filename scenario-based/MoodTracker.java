import java.time.LocalDate;
import java.util.*;

public class MoodTracker {
    private Map<LocalDate, List<String>> moodLog = new HashMap<>();

    public void logMood(LocalDate date, String mood) {
        moodLog.putIfAbsent(date, new ArrayList<>());
        moodLog.get(date).add(mood.toLowerCase());
    }

    public void searchMood(String mood) {
        int count = 0;
        System.out.println("Searching for mood: " + mood);
        for (Map.Entry<LocalDate, List<String>> entry : moodLog.entrySet()) {
            if (entry.getValue().contains(mood.toLowerCase())) {
                count++;
                System.out.println("Date: " + entry.getKey() + " → " + entry.getValue());
            }
        }
        System.out.println("Mood '" + mood + "' occurred " + count + " times.");
    }

    public static void main(String[] args) {
        MoodTracker tracker = new MoodTracker();
        tracker.logMood(LocalDate.now().minusDays(1), "Happy");
        tracker.logMood(LocalDate.now().minusDays(2), "Sad");
        tracker.logMood(LocalDate.now().minusDays(3), "Happy");
        tracker.logMood(LocalDate.now().minusDays(4), "Tired");

        tracker.searchMood("happy");
    }
}
