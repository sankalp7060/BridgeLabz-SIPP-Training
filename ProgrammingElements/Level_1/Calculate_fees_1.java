public class Calculate_fees_1{
  public static void main(String[] args){
    int fees=125000;
    int discountPercent= 10;
    int discount= ((fees*10)/100);
    int discounted_fees=fees-discount;
    System.out.print("The discount amount is "+discount+" and final discounted fee is "+discounted_fees);
  }
}