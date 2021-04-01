package arraysandstrings;

import static utils.PrintUtils.print;

public class RotateMatrix {

    public static Integer[][] rotateMatrix(Integer[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i <= n / 2; i++) {
            for (int j = i; j <= n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Integer[][] input = {
            {8, 1, 2, 7, 5},
            {3, 4, 0, 2, 6},
            {0, 3, 1, 0, 7},
            {4, 0, 7, 2, 8},
            {3, 5, 2, 8, 2}
        };

        print(RotateMatrix.class.getName());

        print("input");
        printMatrix(input);

        Integer[][] output = rotateMatrix(input);

        print("output");
        printMatrix(output);
    }

    private static void printMatrix(Integer[][] matrix) {
        for (Integer[] row : matrix) {
            print(row);
        }
        System.out.println();
    }
}
