import java.util.*;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean f=true;
        int l=0,r=s.length()-1;
        while(l<r){
          if(s.charAt(l)!=s.charAt(r)) f=false;
          l++;
          r--;
        }
        if(f){
          System.out.print("String is a Palindrome");
        }
        else{
          System.out.print("String is not a Palindrome");
        }
    }
}
 