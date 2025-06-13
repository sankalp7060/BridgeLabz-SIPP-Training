import java.util.*;
public class RocketLaunch_2{
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    System.out.print("Counter = ");
    int counter=sc.nextInt();
    for(int i=counter;i>=1;i--){
      System.out.println(counter);
    }
    System.out.print("Rocket Launch");
  }
}