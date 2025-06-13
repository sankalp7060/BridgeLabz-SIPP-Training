import java.util.*;
public class NumberSignCheck{
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    System.out.print("number = ");
    int number=sc.nextInt();
    if(number > 0){
      System.out.print("The number= "+number+" positive ");
    }
    else if(number == 0){
      System.out.print("The number= "+number+" zero ");
    }
    else{
      System.out.print("The number= "+number+" negative ");
    }
  }
}