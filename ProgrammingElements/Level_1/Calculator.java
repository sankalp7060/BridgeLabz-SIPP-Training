import java.util.*;
public class Calculator{
  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    System.out.print("number1= ");
    int number1=sc.nextInt();
    System.out.print("number2= ");
    int number2= sc.nextInt();
    int addition=number1+number2;
    int subtraction=number1-number2;
    int multiplication=number1*number2;
    int division=number1/number2;
    System.out.print("The addition, subtraction, multiplication and division value of 2 numbers "+number1+" and "+number2+" is "+addition+", "+subtraction+", "+multiplication +" and "+division);
  }
}