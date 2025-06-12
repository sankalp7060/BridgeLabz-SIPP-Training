import java.util.*;
public class Price_Calculation{
  public static void main(String[] args){
    System.out.print("unitPrice = ");
    Scanner sc=new Scanner(System.in);
    int unitPrice=sc.nextInt();
    System.out.print("quantity = ");
    int quantity=sc.nextInt();
    int total_price=unitPrice*quantity;
    System.out.print("The total purchase price is "+total_price+" if the quantity  "+quantity+" and unit price is "+unitPrice);
  }
}