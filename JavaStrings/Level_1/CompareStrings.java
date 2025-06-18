import java.util.*;
public class CompareStrings{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s1=sc.next();
    String s2=sc.next();
    boolean result1 = check(s1, s2);
    boolean result2 = s1.equals(s2);
    System.out.println("Custom check result: " + result1);
    System.out.println("Built-in equals result: " + result2);
    System.out.println("Both results are same: " + (result1 == result2));

  }
  public static boolean check(String s1,String s2){
    if(s1.length()!=s2.length()) return false;
    for(int i=0;i<s1.length();i++){
      if(s1.charAt(i) != s2.charAt(i)) return false;
    }
    return true;
  }
}