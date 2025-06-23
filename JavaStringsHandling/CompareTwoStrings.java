import java.util.*;

public class CompareTwoStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first string:- ");
        String s1 = sc.nextLine();
        System.out.print("Enter the second string:- ");
        String s2 = sc.nextLine();
        int result=check(s1,s2);
        if(result==0){
          System.out.print("Both the strings are equal");
        }
        else if(result<0){
          System.out.print(s1+" comes before "+s2+" in lexicographical order");
        }
        else{
          System.out.print(s1+" comes after "+s2+" in lexicographical order");
        }
    }
    public static int check(String s1,String s2){
      int l1=s1.length();
      int l2=s2.length();
      int minlength=Math.min(l1,l2);
      for(int i=0;i<minlength;i++){
        int ch1=s1.charAt(i);
        int ch2=s2.charAt(i);
        if(ch1!=ch2) return ch1-ch2;
      }
      return l1-l2;
    }
}
 