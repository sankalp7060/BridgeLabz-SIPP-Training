public class Calculate_Volume{
  public static void main(String[] args){
    int radius= 6378;
    double volume_in_kilometers= ((4/3)*3.14*radius);
    double volume_in_miles= volume_in_kilometers*1.6;
    System.out.print("The volume of earth in cubic kilometers is "+volume_in_kilometers+" and cubic miles is "+volume_in_miles);
  }
}