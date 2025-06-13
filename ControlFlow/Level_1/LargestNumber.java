import java.util.*;
public class LargestNumber{
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    System.out.print("number1 = ");
    int number1=sc.nextInt();
    System.out.print("number2 = ");
    int number2=sc.nextInt();
    System.out.print("number3 = ");
    int number3=sc.nextInt();
    if(number1 > number2 && number1 > number3){
      System.out.println("Is the first number the largest? "+true);
    }
    else{
      System.out.println("Is the first number the largest? "+false);
    }
    if(number2 > number1 && number2 > number3){
      System.out.println("Is the second number the largest? "+true);
    }
    else{
      System.out.println("Is the second number the largest? "+false);
    }
    if(number3 > number1 && number3 > number2){
      System.out.println("Is the third number the largest? "+true);
    }
    else{
      System.out.println("Is the third number the largest? "+false);
    }
  }
}