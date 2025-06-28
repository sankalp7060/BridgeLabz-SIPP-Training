import java.util.*;
public class CoffeeCounter{
  static double coffeeBill=0;
  static double GST=0.18;
  static double totalBill=0;
  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    System.out.println("Welcome! TO the Coffee Mania");
    String[] coffeeTypes={"Americano", "Cappuccino", "Espresso", "Latte"};
    int[] coffeePrice={500,600,700,800};
    System.out.println("Currently we have these options for you:- ");
    while(true){
      for(int i=0;i<coffeeTypes.length;i++){
        System.out.println((i+1)+". "+coffeeTypes[i]+"for:- "+coffeePrice[i]);
      }
      System.out.println("Press 1 for Americano, 2 for Cappuccino, 3 for Espresso, 4 for Latte,5 for exit:- ");
      int coffee=0;
      while(true){
        System.out.print("Enter your choice: ");
        coffee=sc.nextInt();
        sc.nextLine();
        if(coffee>=1 && coffee<=4) break;
        System.out.println("Please press the right number:- ");
        if (coffee == 5) {
          System.out.println("Thank you for visiting Coffee Mania!");
          return;
        }
      }
      String customerCoffee=customerCoffee(coffee);
      coffeeBill+=coffeePrice[coffee-1];
      System.out.println("Would you like to order more??(yes/no):- ");
      String moreOrder=sc.nextLine();
      if(moreOrder.toLowerCase().equals("no")){
        totalBill = coffeeBill + (coffeeBill * GST);
        System.out.println("Your bill Sir:- "+totalBill);
        break;
      }
    }
  }
  public static String customerCoffee(int coffee){
    if(coffee==1) return "You have ordered Americano";
    else if(coffee==2) return "You have ordered Cappuccino";
    else if(coffee==3) return "You have ordered Espresso";
    else if(coffee==4) return "You have ordered Latte";
    else if(coffee==5) return "Thank You for the visit sir";
    return null;
  }
}