import java.util.*;

public class ExamSeatChecker {
    public static int binarySearch(int[] row, int target) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] == target) return mid;
            else if (row[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -left - 1; // insertion point
    }

    public static void checkSeat(int[][] halls, int seatNumber) {
        for (int i = 0; i < halls.length; i++) {
            int pos = binarySearch(halls[i], seatNumber);
            if (pos >= 0) {
                System.out.println("Seat found in Hall " + (i + 1) + " at position " + pos);
                return;
            }
        }

        System.out.println("Seat not found.");
        // Suggest nearest
        for (int i = 0; i < halls.length; i++) {
            int pos = -binarySearch(halls[i], seatNumber) - 1;
            if (pos < halls[i].length) {
                System.out.println("Nearest available seat in Hall " + (i + 1) + ": " + halls[i][pos]);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[][] halls = {
            {101, 102, 103, 104},
            {201, 202, 203, 204},
            {301, 302, 303, 304}
        };

        checkSeat(halls, 203);
        checkSeat(halls, 205);
    }
}
