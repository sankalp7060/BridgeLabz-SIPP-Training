import java.util.*;

public class ArrayIndexOutOfBoundsException{
    public static void main(String[] args) {
        handleException();
    }
    public static void handleException() {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Alice", "Bob", "Charlie"};
        int index = sc.nextInt();
        try {
            System.out.println(names[index]); 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
