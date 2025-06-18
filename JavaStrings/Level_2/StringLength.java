import java.util.*;
public class StringLength{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s=sc.next();
    System.out.println("Length without using string.length():- "+check(s));
    System.out.println("Length using string.length():- "+s.length());
  }
  public static int check(String s){
    int length=0;
    try{
      while(true){
        s.charAt(length);
        length++;
      }
    }catch(Exception e){
      
    }
    return length;
  }
}