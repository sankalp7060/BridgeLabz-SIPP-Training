import java.util.*;

public class StringIndexOutOfBoundsException{
    public static void main(String[] args) {
        handleException();
    }
    public static void handleException() {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        try {
            System.out.println(text.charAt(text.length())); 
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
