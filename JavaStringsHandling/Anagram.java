import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first string:- ");
        String s1 = sc.nextLine();
        System.out.print("Enter the second string:- ");
        String s2 = sc.nextLine();
        if(check(s1,s2)) System.out.print("Two String are Anagram!");
        else System.out.print("Two String are not Anagram!");
    }
    public static boolean check(String s1,String s2){
      if(s1.length()!=s2.length()) return false;
      int[] f=new int[256];
      for(int i=0;i<s1.length();i++){
        f[s1.charAt(i)]++;
        f[s2.charAt(i)]--;
      }
      for(int i:f){
        if(i!=0) return false;
      }
      return true;
    }
}
