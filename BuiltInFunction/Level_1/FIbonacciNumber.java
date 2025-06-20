import java.util.*;
public class FIbonacciNumber{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=getInput(sc);
    generateFibonacci(n);
  }
  public static int getInput(Scanner sc){
    System.out.print("Enter the number:- ");
    return sc.nextInt();
  }
  public static void generateFibonacci(int n){
    if(n<=0){
      System.out.print("Please enter the positive number!");
      return;
    }
    int a=0,b=1;
    System.out.println("Fibonacci sequence up to " + n + " terms:");
    for(int i=1;i<=n;i++){
      System.out.print(a+" ");
      int next=a+b;
      a=b;
      b=next;
    }
  }
}