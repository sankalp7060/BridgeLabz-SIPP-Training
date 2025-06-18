import java.util.*;

public class  IllegalArgumentException{
    public static void main(String[] args) {
        handleException();
    }
    public static void handleException() {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
