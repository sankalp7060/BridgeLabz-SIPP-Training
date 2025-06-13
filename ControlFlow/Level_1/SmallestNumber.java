import java.util.*;
public class SmallestNumber{
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    System.out.print("number1 = ");
    int number1=sc.nextInt();
    System.out.print("number2 = ");
    int number2=sc.nextInt();
    System.out.print("number3 = ");
    int number3=sc.nextInt();
    if(number1 < number2 && number1 < number3){
      System.out.print("Is the first number the smallest? "+true);
    }
    else{
      System.out.print("Is the first number the smallest? "+false);
    }
  }
}