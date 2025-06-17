package Level_1;
import java.util.Scanner;
public class Multiplication6To9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number between 6 and 9: ");
        int number=sc.nextInt();
        if(number < 6 || number > 9) {
            System.out.println("Please enter a valid number between 6 and 9.");
        } else {
            System.out.println("Multiplication table for " + number + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
        }

    
}
}