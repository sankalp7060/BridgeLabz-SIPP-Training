import java.util.Scanner;

public class Area_of_triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base in cm: ");
        double base = sc.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = sc.nextDouble();

        double areaCm = 0.5 * base * height;
        double areaInches = areaCm / (2.54 * 2.54);

        System.out.println("The Area of the triangle in sq in is " + areaInches + " and sq cm is " + areaCm);
    }
}
