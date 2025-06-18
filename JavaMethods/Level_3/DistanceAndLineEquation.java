public class DistanceAndLineEquation {

    public static double calculateEuclideanDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] calculateLineEquation(int x1, int y1, int x2, int y2) {
        double slope = (double)(y2 - y1) / (x2 - x1);
        double intercept = y1 - slope * x1;
        return new double[] { slope, intercept };
    }

    public static void main(String[] args) {
        int x1 = 2, y1 = 4;
        int x2 = 6, y2 = 8;

        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        double[] result = calculateLineEquation(x1, y1, x2, y2);

        System.out.printf("Euclidean Distance: %.2f\n", distance);
        System.out.printf("Line Equation: y = %.2fx + %.2f\n", result[0], result[1]);
    }
}