import java.util.Scanner;

public class FootballTeamHeightStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[11];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + (int)(Math.random() * (205 - 150 + 1));
            sum += heights[i];
            if (heights[i] < min) {
                min = heights[i];
            }
            if (heights[i] > max) {
                max = heights[i];
            }
        }

        double mean = (double) sum / heights.length;

        System.out.println("Heights of players:");
        for (int height : heights) {
            System.out.print(height + " ");
        }
        System.out.println();
        System.out.println("Shortest height: " + min);
        System.out.println("Tallest height: " + max);
        System.out.println("Mean height: " + mean);
    }
}