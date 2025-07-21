import java.util.*;

public class HighScoreFinder {
    public static void findScore(List<Integer> scores, int playerScore) {
        int index = Collections.binarySearch(scores, playerScore, Comparator.reverseOrder());
        if (index >= 0) {
            System.out.println("Congratulations! You're ranked #" + (index + 1));
        } else {
            int insertPos = -index - 1;
            if (insertPos < 100) {
                int needed = scores.get(99);
                System.out.println("You need at least " + (needed - playerScore + 1) + " more points to reach Top 100.");
            } else {
                System.out.println("Score too low for Top 100.");
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> topScores = new ArrayList<>();
        for (int i = 1000; i >= 901; i--) topScores.add(i); // top 100 scores

        findScore(topScores, 950);
        findScore(topScores, 890);
    }
}
