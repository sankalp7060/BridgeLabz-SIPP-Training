import java.util.*;
public class RocketLaunch_1{
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    System.out.print("Counter = ");
    int counter=sc.nextInt();
    while(counter-->=1){
      System.out.println(counter);
    }
    System.out.print("Rocket Launch");
  }
}