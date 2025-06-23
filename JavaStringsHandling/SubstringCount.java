import java.util.*;

public class SubstringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main string:- ");
        String main = sc.nextLine();
        System.out.println("Enter the substring string:- ");
        String sub=sc.nextLine();
        int count=0;
        
        while ((i = main.indexOf(sub, i)) != -1) {
            count++;
            i += sub.length(); 
        }
        System.out.print(count);
    }
}
 