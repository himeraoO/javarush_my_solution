package com.javarush.task.task39.task3909;
import java.util.*;
import java.lang.Integer;

/* 
Одно изменение
*/

public class Solution {
    public static void main(String[] args) {

    }

//    public static boolean isOneEditAway(String first, String second) {
//
//        //   if(first.length() == second.length()){
//
//        //     if(first.length() > 1 || second.length() > 1){
//
//        //         if (first.isEmpty() || second.isEmpty()) {
//        //         return false;
//        //         }
//        //     }
//        //   }
//        //       return true;
//        // }
//
//        if (first.isEmpty() && second.isEmpty()) {
//            return true;
//        }
//        if ((first.length() - second.length()) == -1) {
//            return calculate(second, first) == 1;
//        }else {
//            return calculate(first, second) == 1;
//        }
////        return false;
//    }
//
//public static int calculate(String x, String y) {
//    // int[][]dp = new int[x.length() + 1][y.length() + 1];
//
//    // for (int i = 0; i <= x.length(); i++) {
//    //     for (int j = 0; j <= y.length(); j++) {
//    //         if (i == 0) {
//    //             dp[i][j]= j;
//    //         }
//    //         else if (j == 0) {
//    //             dp[i][j]= i;
//    //         }
//    //         else {
//    //             dp[i][j]= min(dp[i - 1][j - 1]
//    //              + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
//    //               dp[i - 1][j]+ 1,
//    //               dp[i][j - 1]+ 1);
//    //         }
//    //     }
//    // }
//    // return dp[x.length()][y.length()];
//
//    if (x.isEmpty()) {
//            return y.length();
//        }
//
//        if (y.isEmpty()) {
//            return x.length();
//        }
//
//        int substitution = calculate(x.substring(1), y.substring(1))
//         + costOfSubstitution(x.charAt(0), y.charAt(0));
//        int insertion = calculate(x, y.substring(1)) + 1;
//        int deletion = calculate(x.substring(1), y) + 1;
//
//        return min(substitution, insertion, deletion);
//}
//
//public static int costOfSubstitution(char a, char b) {
//        return a == b ? 0 : 1;
//    }
//
//     public static int min(int... numbers) {
//        return Arrays.stream(numbers)
//          .min().orElse(Integer.MAX_VALUE);
//    }
//
public static boolean isOneEditAway(String first, String second) {
    int lengthDifference = first.length() - second.length();

    if (lengthDifference == 0) {
        return checkReplacement(first, second);
    } else if (lengthDifference == 1) {
        return checkInsertion(first, second);
    } else if (lengthDifference == -1) {
        return checkInsertion(second, first);
    } else {
        return false;
    }
}

    private static boolean checkReplacement(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifference) {
                    return false;
                } else {
                    foundDifference = true;
                }
            }
        }
        return true;
    }

    private static boolean checkInsertion(String first, String second) {
        int i = 0;
        int j = 0;

        while (j < second.length() && i < first.length()) {
            if (first.charAt(i) != second.charAt(j)) {
                if (i != j) {
                    return false;
                }
                i++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}
