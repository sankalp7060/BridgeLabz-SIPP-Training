public class MovieTime {
    public static void insertShow(int[] shows, int newTime) {
        int i = shows.length - 1;
        while (i >= 0 && shows[i] == 0) i--; // skip empty slots

        int pos = i + 1;
        while (pos > 0 && shows[pos - 1] > newTime) {
            shows[pos] = shows[pos - 1];
            pos--;
        }
        shows[pos] = newTime;
    }

    public static void main(String[] args) {
        int[] showTimes = new int[10]; // Fixed size list with room for additions
        int[] inputs = {1430, 900, 1200, 1700, 1300}; // show times in 24hr format

        for (int time : inputs) {
            insertShow(showTimes, time);
        }

        System.out.println("Sorted showtimes:");
        for (int time : showTimes) {
            if (time != 0)
                System.out.println(time);
        }
    }
}
