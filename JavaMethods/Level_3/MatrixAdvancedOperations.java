public class MatrixAdvancedOperations {

    public static int[][] createMatrix(int[][] data) {
        return data;
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                transposed[j][i] = matrix[i][j];
        return transposed;
    }

    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static int determinant3x3(int[][] m) {
        int det = m[0][0] * (m[1][1]*m[2][2] - m[1][2]*m[2][1])
                - m[0][1] * (m[1][0]*m[2][2] - m[1][2]*m[2][0])
                + m[0][2] * (m[1][0]*m[2][1] - m[1][1]*m[2][0]);
        return det;
    }

    public static double[][] inverse2x2(int[][] matrix) {
        int det = determinant2x2(matrix);
        if (det == 0) return null;

        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / (double)det;
        inverse[0][1] = -matrix[0][1] / (double)det;
        inverse[1][0] = -matrix[1][0] / (double)det;
        inverse[1][1] = matrix[0][0] / (double)det;
        return inverse;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }

    public static void printMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix is not invertible.");
            return;
        }
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%.2f\t", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix2x2 = {{4, 7}, {2, 6}};
        int[][] matrix3x3 = {{1, 2, 3}, {0, 4, 5}, {1, 0, 6}};

        System.out.println("Original 2x2 Matrix:");
        printMatrix(matrix2x2);

        System.out.println("Transpose:");
        printMatrix(transpose(matrix2x2));

        System.out.println("Determinant of 2x2 Matrix: " + determinant2x2(matrix2x2));

        System.out.println("Inverse of 2x2 Matrix:");
        printMatrix(inverse2x2(matrix2x2));

        System.out.println("\nOriginal 3x3 Matrix:");
        printMatrix(matrix3x3);

        System.out.println("Transpose:");
        printMatrix(transpose(matrix3x3));

        System.out.println("Determinant of 3x3 Matrix: " + determinant3x3(matrix3x3));
    }
}