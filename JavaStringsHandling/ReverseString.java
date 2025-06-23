import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse=new StringBuilder(s).reverse().toString();
        System.out.print("Reversed String:- "+reverse);
    }
}
 