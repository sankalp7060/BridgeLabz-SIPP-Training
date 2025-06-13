import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int physics = sc.nextInt();
        int chemistry = sc.nextInt();
        int maths = sc.nextInt();
        double percentage = (physics + chemistry + maths) / 3.0;
        System.out.println("Average: " + percentage);
        if (percentage >= 90) System.out.println("Grade: A+");
        else if (percentage >= 80) System.out.println("Grade: A");
        else if (percentage >= 70) System.out.println("Grade: B+");
        else if (percentage >= 60) System.out.println("Grade: B");
        else if (percentage >= 50) System.out.println("Grade: C");
        else System.out.println("Grade: F");
    }
}
