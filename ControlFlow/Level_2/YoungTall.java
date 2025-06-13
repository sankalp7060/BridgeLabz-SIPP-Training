import java.util.Scanner;

public class YoungTall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Amar's age: ");
        int age1 = sc.nextInt();
        System.out.print("Enter Akbar's age: ");
        int age2 = sc.nextInt();
        System.out.print("Enter Anthony's age: ");
        int age3 = sc.nextInt();

    
        System.out.print("Enter Amar's height: ");
        double height1 = sc.nextDouble();
        System.out.print("Enter Akbar's height: ");
        double height2 = sc.nextDouble();
        System.out.print("Enter Anthony's height: ");
        double height3 = sc.nextDouble();

     
        String youngest = "Amar";
        int minAge = age1;
        if (age2 < minAge) {
            youngest = "Akbar";
            minAge = age2;
        }
        if (age3 < minAge) {
            youngest = "Anthony";
            minAge = age3;
        }

        
        String tallest = "Amar";
        double maxHeight = height1;
        if (height2 > maxHeight) {
            tallest = "Akbar";
            maxHeight = height2;
        }
        if (height3 > maxHeight) {
            tallest = "Anthony";
            maxHeight = height3;
        }

        System.out.println("The youngest friend is " + youngest + " with age " + minAge);
        System.out.println("The tallest friend is " + tallest + " with height " + maxHeight);
    }
}
