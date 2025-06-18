import java.util.*;
public class CompareStrings{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s1=sc.next();
    String s2=sc.next();
    if(check(s1,s2)==s1.equals(s2)){
      System.out.print(true);
    } 
    else{
      System.out.print(false);
    }
  }
  public static boolean check(String s1,String s2){
    if(s1.length()!=s2.length()) return false;
    for(int i=0;i<s1.length();i++){
      if(s1.charAt(i) != s2.charAt(i)) return false;
    }
    return true;
  }
}