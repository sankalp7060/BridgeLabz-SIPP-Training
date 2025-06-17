package Level_1;
import java.util.Scanner;
public class NumberCheck {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int numbers[] = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] >0){
                if(numbers[i] % 2 == 0){
                    System.out.println(numbers[i] + " is a positive even number.");
                } else {
                    System.out.println(numbers[i] + " is a positive odd number.");
                }
            }
            else if(numbers[i] < 0){
                if(numbers[i] % 2 == 0){
                    System.out.println(numbers[i] + " is a negative even number.");
                } else {
                    System.out.println(numbers[i] + " is a negative odd number.");
                }
            } else {
                System.out.println(numbers[i] + " is zero.");
            }
        }
    
     if (numbers[0] == numbers[4]) {
            System.out.println("First and last elements are equal");
        } else if (numbers[0] > numbers[4]) {
            System.out.println("First element is greater than the last");
        } else {
            System.out.println("First element is less than the last");
        }
    }


    
}
