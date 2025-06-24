import java.util.*;
public class MobilePhone{
  private String brand;
  private String model;
  private int price;
  public MobilePhone(String brand,String model,int price){
    this.brand=brand;
    this.model=model;
    this.price=price;
  }
  public void displayDetails(){
    System.out.println("Mobile phone brand:- "+brand);
    System.out.println("Mobile phone model:- "+model);
    System.out.println("Mobile phone price:- "+price);
  }

  public static void main(String[] args){
    String brand="Vivo";
    String model="2025";
    int price=20000;
    MobilePhone phone=new MobilePhone(brand,model,price);
    phone.displayDetails();
  }
}