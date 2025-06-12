import java.util.*;
public class distance_in__yards_miles{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.print("distanceInFeet = ");
    double distanceInFeet=sc.nextDouble();
    double distance_in_yards = (distanceInFeet/3);
    double distance_in_miles = (distanceInFeet/3)/1760;
    System.out.print("The distance in feet is "+distanceInFeet+" while in miles is "+distance_in_miles+" and yards is "+distance_in_yards);
  }
}