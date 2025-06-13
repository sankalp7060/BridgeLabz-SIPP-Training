import java.util.*;
public class Divisibility{
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    System.out.print("number = ");
    int number=sc.nextInt();
    if(number%5==0){
      System.out.print("Is the number= "+number+" divisible by 5? "+true);
    }
    else{
      System.out.print("Is the number= "+number+" divisible by 5? "+false);
    }
  }
}