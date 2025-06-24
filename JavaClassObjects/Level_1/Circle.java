import java.util.*;
public class Circle{
  private int radius;
  public Circle(int radius){
    this.radius=radius;
  }
  public double area(){
    return (double)(Math.PI*radius*radius);
  }
  public double circumference(){
    return (double)(2*Math.PI*radius);
  }
  public static void main(String[] args){
    int radius =7;
    Circle circle=new Circle(radius);
    double area=circle.area();
    double circumference=circle.circumference();
    System.out.println("Area of Circle:- "+area);
    System.out.println("Circumference of Circle:- "+circumference);
  }
}