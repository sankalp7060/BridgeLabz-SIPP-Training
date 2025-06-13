public class Calculate_profit_loss{
  public static void main(String[] args){
    int cost_price = 129;
    int selling_price = 191;
    int profit = selling_price-cost_price;
    double profit_percent= (profit/(double)cost_price)*100;
    String result = "The Cost Price is " + cost_price + " and Selling Price is " + selling_price + "\n"+ "The Profit is " + profit+ " and The Profit Percentage is " + profit_percent;
    System.out.println(result);
  }
}