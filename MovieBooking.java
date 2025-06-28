import java.util.*;
public class MovieBooking{
  static String allMeal="";
  static int totalMeal=0;
  static int totalSeat=0;
  public static void main(String[] args){
    System.out.println("Welcome to MovieShala:- ");
    while(true){
      Scanner sc=new Scanner(System.in);
      System.out.println("Please tell the type of seat you want to take:- ");
      System.out.println("Price of Seats:- Silver for 300, Gold for 500, Platinum for 700");
      System.out.println("Press 1 for silver seat, 2 for gold seat, 3 for platinum seat");
      int seatNum=sc.nextInt();
      String seatType=seatSelect(seatNum);
      System.out.println("Do you want any meal(yes/no):- ");
      String isMeal=sc.next();
      if(isMeal.equals("yes")){
        while(true){
          System.out.println("Currently! We have these meals:-");
          System.out.println("Pizza for 400, Burgar for 200, PopCorn for 100");
          System.out.println("Which one would you like to order:- ");
          System.out.println("Press 1 for Pizaa, 2 for Burgar, 3 for PopCorn, 4 for nothing");
          int mealNum=sc.nextInt();
          if(mealNum==4) break;
          String meal= whichMeal(mealNum);
        }
      }
      else{
        System.out.print("Ok sir");
      }
      System.out.println("Would you like to more tickets??");
      System.out.println("Press 1 for yes , 2 for No");
      int isMore=sc.nextInt();
      if(isMore==2) {
        int total=totalMeal+totalSeat;
        System.out.print("Your Bill Sir:- "+total);
        System.out.print("ThankYou for your time sir");
        break;
      }
    }
  }
  public static String whichMeal(int mealNum){
      if(mealNum==1){
        totalMeal+=400;
        return allMeal+"Pizza";
      }
      else if(mealNum==2)  {
        totalMeal+=200;
        return allMeal+"Burgar";
      }
      else if(mealNum==3)  {
        totalMeal+=100;
        return allMeal+"PopCorn";
      }
      else return ("Sorry! you have choosen wrong one");
  }
  public static String seatSelect(int seatType){
    if(seatType==1) {
      totalSeat+=300;
      return "You have selected Silver seat";
    }
    else if(seatType==2)  {
      totalSeat+=500;
      return ("You have selected Gold seat");
    }
    else if(seatType==3) {
      totalSeat+=700;
      return ("You have selected Platinum seat");
    }
    else return ("Sorry! you have choosen wrong one");
  }
}