import java.util.*;
public class Cm_to_foot_inches{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("height = ");
    double height=sc.nextDouble();
    double height_in_foot = (height/2.54)/12;
    double height_in_inches = (height/2.54);
    System.out.print("Your Height in cm is "+height+" while in feet is "+height_in_foot+" and inches is "+height_in_inches);
  }
}