import java.util.*;
public class CompareSubstring{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter String:- ");
    String s=sc.next();
    System.out.print("Enter start index:- ");
    int start=sc.nextInt();
    System.out.print("Enter end index:- ");
    int end=sc.nextInt();
    String sub1=check(s,start,end);
    String sub2=s.substring(start,end+1);
    if(sub1.equals(sub2)) System.out.print(true);
    else System.out.print(false);
  }
  public static String check(String s,int start,int end){
    String sub="";
    for(int i=start;i<=end;i++){
      sub+=s.charAt(i);
    }
    return sub;
  }
}