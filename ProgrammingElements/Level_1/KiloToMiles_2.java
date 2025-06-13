import java.util.*;
public class KiloToMiles_2{
  public static void main(String[] args){
    System.out.print("km = ");
    Scanner sc=new Scanner(System.in);
    double kilometers=sc.nextDouble();
    double miles=1.6*kilometers;
    System.out.print("The total miles is "+miles+" mile for the given  "+kilometers+" km");
  }
}