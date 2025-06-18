import java.util.*;
public class CompareStrings{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter lowercase string:- ");
    String s=sc.next();
    String toUpper=toUpperCase(s);
    s = s.toUpperCase();
    if(compare(toUpper,s)) System.out.print(true);
    else System.out.print(false);
  }
  public static String toUpperCase(String s){
    String toUpper="";
    for(int i=0;i<s.length();i++){
      char ch = s.charAt(i);
      if (ch >= 'a' && ch <= 'z') {
        result += (char)(ch - 32);  
      } else {
        result += ch; 
      }
    }
    return toUpper;
  }
  public static boolean compare(String toUpper,String s){
    if(s.length()!=toUpper.length()) return false;
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)!=toUpper.charAt(i)) return false;
    }
    return true;
  }
}