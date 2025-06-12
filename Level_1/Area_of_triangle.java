import java.util.*;
public class Area_of_triangle{
  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    System.out.print("base= ");
    int base=sc.nextInt();
    System.out.print("height= ");
    int height= sc.nextInt();
    int area=(base*height)/2;
    System.out.print("Area of Triangle= "+area+" cm^2");
  }
}