import java.util.*;
public class Perimeter_of_square{
  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    System.out.print("side= ");
    int side=sc.nextInt();
    int perimeter= 4*side;
    System.out.print("The length of the side is "+side+" whose perimeter is "+perimeter);
  }
}