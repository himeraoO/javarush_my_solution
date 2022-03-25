package com.javarush.task.task39.task3912;
import java.util.*;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int maxSquare(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int side = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i * j == 0) continue;
                if (matrix[i][j] == 1) {
                    matrix[i][j] = min(matrix[i][j - 1], matrix[i - 1][j], matrix[i - 1][j - 1]) + 1;
                }
                if (matrix[i][j] > side) {
                    side = matrix[i][j];
                }
            }
        }
        return side * side;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

}
