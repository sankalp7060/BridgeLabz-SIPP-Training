import java.util.*;
public class PrimeChecker{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=getInput(sc);
    if(isPrime(n)){
      System.out.print("The number you have entered is a prime number!");
    }
    else{
      System.out.print("The number you have entered is not a prime number!");
    }
  }
  public static int getInput(Scanner sc){
    System.out.print("Enter the number:- ");
    return sc.nextInt();
  }
  public static boolean isPrime(int n){
    if(n<=1) return false;
    if(n==2) return true;
    if(n%2==0) return false;
    for(int i=3;i<=n/2;i++){
      if(n%i==0) return false;
    }
    return true;
  }
}