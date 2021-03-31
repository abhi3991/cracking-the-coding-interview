package arraysandstrings;

import static utils.PrintUtils.print;

public class ZeroMatrix {

    public static Integer[][] convertToZeroMatrix(Integer[][] matrix) {
        boolean firstRowHasZero = false, firstColHasZero = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRowHasZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[0][i] = 0;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Integer[][] input = {
            {8, 1, 2, 7},
            {3, 4, 0, 2},
            {0, 3, 1, 0},
            {4, 0, 7, 2}
        };

        print(ZeroMatrix.class.getName());

        print("input");
        for (Integer[] row : input) {
            print(row);
        }

        print("output");
        Integer[][] output = convertToZeroMatrix(input);
        for (Integer[] row : output) {
            print(row);
        }
    }
}
