import java.util.*;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans="";
        String[] words=s.split("\\s");
        for(String i:words){
          if(i.length()>ans.length()) ans=i;
        }
        System.out.print("Longest word:- "+ans);
    }
}
 