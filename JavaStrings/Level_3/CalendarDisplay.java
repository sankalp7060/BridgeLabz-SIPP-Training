import java.util.Scanner;

public class CalendarDisplay {
    static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }

    static int getNumberOfDays(int month, int year) {
        int[] days = {31, (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28,
                31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return days[month - 1];
    }

    static int getStartDay(int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int q = 1;
        int k = year % 100;
        int j = year / 100;
        int h = (q + 13 * (month + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
        return (h + 6) % 7;
    }

    static void printCalendar(int month, int year) {
        int startDay = getStartDay(month, year);
        int numDays = getNumberOfDays(month, year);
        System.out.println("    " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < startDay; i++)
            System.out.print("    ");

        for (int i = 1; i <= numDays; i++) {
            System.out.printf("%3d ", i);
            if ((i + startDay) % 7 == 0)
                System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int year = sc.nextInt();
        printCalendar(month, year);
    }
}
