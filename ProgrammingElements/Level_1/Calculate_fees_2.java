import java.util.*;
public class Calculate_fees_2{
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    System.out.print("fee = ");
    int fee=sc.nextInt();
    System.out.print("discountPercent = ");
    int discountPercent= sc.nextInt();
    int discount= ((fee*discountPercent)/100);
    int discounted_fee=fee-discount;
    System.out.print("The discount amount is "+discount+" and final discounted fee is "+discounted_fee);
  }
}