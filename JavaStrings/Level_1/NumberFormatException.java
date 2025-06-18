import java.util.*;

public class NumberFormatException{
    public static void main(String[] args) {
        handleException();
    }
    public static void handleException() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        try {
            int number = Integer.parseInt(input);
            System.out.println("Parsed Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
