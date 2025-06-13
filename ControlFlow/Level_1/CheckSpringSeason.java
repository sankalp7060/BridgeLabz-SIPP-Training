
import java.util.*;

public class CheckSpringSeason {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the day = ");
        int day = sc.nextInt();
        System.out.print("Enter the month (1-12)= ");
        int month = sc.nextInt();
        if ((month == 3 && day >= 20 && day <= 31)|| 
            (month == 4 && day >= 1 && day <= 30)|| 
            (month == 5 && day >= 1 && day <= 31)||
            (month == 6 && day >= 1 && day <= 20)) {
              System.out.print("Its a Spring Seaso");
        } else {
            System.out.print("Not a Spring Season");
        }
    }
}
