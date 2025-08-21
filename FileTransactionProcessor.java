import java.io.IOException;
import java.nio.file.*;
import java.util.*;

class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

public class FileTransactionProcessor {
    public static void main(String[] args) {
        List<Integer> transactions = new ArrayList<>();

        try {
            Files.lines(Paths.get("transactions.txt")).forEach(line -> {
                try {
                    int amount = Integer.parseInt(line.trim());
                    if (amount < 0) {
                        throw new InvalidTransactionException("Negative transaction not allowed: " + amount);
                    }

                    transactions.add(amount);

                } catch (NumberFormatException e) {
                    System.out.println("InvalidTransactionException: Invalid transaction data: " + line);
                } catch (InvalidTransactionException e) {
                    System.out.println(e.getMessage());
                }
            });

            if (!transactions.isEmpty()) {
                int sum = transactions.stream().mapToInt(Integer::intValue).sum();
                int max = transactions.stream().mapToInt(Integer::intValue).max().getAsInt();

                System.out.println("Sum of Transactions: " + sum);
                System.out.println("Max Transaction: " + max);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
