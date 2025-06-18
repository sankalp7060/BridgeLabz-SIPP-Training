import java.util.*;
public class CompareSubstring{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter String:- ");
    String s=sc.next();
    char[] arr1=check(s);
    char[] arr2=s.toCharArray();
    boolean isEqual=compare(arr1,arr2);
    System.out.print(isEqual);
  }
  public static char[] check(String s){
    char[] arr=new char[s.length()];
    for(int i=0;i<s.length();i++){
      arr[i]=s.charAt(i);
    }
    return arr;
  }
  public static boolean compare(char[] arr1,char[] arr2){
    if(arr1.length != arr2.length) return false;
    for(int i=0;i<arr1.length;i++){
      if(arr1[i]!=arr2[i]) return false;
    }
    return true;
  }
}