import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        float number1 = sc.nextFloat();
        System.out.print("Enter second number: ");
        float number2 = sc.nextFloat();

        float sum = number1 + number2;
        float difference = number1 - number2;
        float product = number1 * number2;
        float division = number1 / number2;

        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " + number1 + " and " + number2 + 
                           " is " + sum + ", " + difference + ", " + product + ", and " + division);
    }
}
