import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3); 
        if (choice == 0) return "rock";
        if (choice == 1) return "paper";
        return "scissors";
    }

    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";

        if (user.equals("rock") && computer.equals("scissors") ||
            user.equals("scissors") && computer.equals("paper") ||
            user.equals("paper") && computer.equals("rock")) {
            return "User";
        }
        return "Computer";
    }

    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][3];
        double userPercent = ((double) userWins / totalGames) * 100;
        double compPercent = ((double) computerWins / totalGames) * 100;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercent) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", compPercent) + "%";

        return stats;
    }

    public static void displayGameResults(String[][] gameResults, String[][] stats) {
        System.out.printf("\n%-10s %-15s %-15s %-10s\n", "Game", "User Choice", "Computer Choice", "Winner");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.printf("%-10s %-15s %-15s %-10s\n",
                    gameResults[i][0], gameResults[i][1], gameResults[i][2], gameResults[i][3]);
        }

        System.out.println("\nSummary:");
        System.out.printf("%-10s %-10s %-15s\n", "Player", "Wins", "Win %");
        System.out.println("----------------------------------------");
        for (int i = 0; i < stats.length; i++) {
            System.out.printf("%-10s %-10s %-15s\n", stats[i][0], stats[i][1], stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games to play: ");
        int games = sc.nextInt();
        sc.nextLine(); 
        String[][] gameResults = new String[games][4];
        int userWins = 0, computerWins = 0;

        for (int i = 0; i < games; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String userChoice = sc.nextLine().toLowerCase();

            String compChoice = getComputerChoice();
            String winner = findWinner(userChoice, compChoice);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;

            gameResults[i][0] = "Game " + (i + 1);
            gameResults[i][1] = userChoice;
            gameResults[i][2] = compChoice;
            gameResults[i][3] = winner;
        }

        String[][] stats = calculateStats(userWins, computerWins, games);
        displayGameResults(gameResults, stats);
    }
}
