import java.util.*;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans="";
        for(char i:s.toCharArray()){
          if(Character.isUpperCase(i)){
            ans+=Character.toLowerCase(i);
          }
          else if(Character.isLowerCase(i)){
            ans+=Character.toUpperCase(i);
          }
          else{
            ans+=i;
          }
        }
        System.out.print(ans);
    }
}
 