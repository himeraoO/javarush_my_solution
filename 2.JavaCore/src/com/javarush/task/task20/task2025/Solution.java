package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/

public class Solution {
//    static TreeSet<Long> longs = new TreeSet<>();
//    static long[][] longsstep = initStep();
//
//     static long[][] initStep(){
//        //Long.MaxValue = 9223372036854775807 // 19 символов
//        long[][] step = new long[9][19];
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 19; j++) {
//                    step[i][j] = Math.round(Math.pow(i+1, j+1));
////                for (int k = 0; k < j; k++) {
////                    if(j==0){
////                        step[i][j]=(i+1);
////                    }else {
////                        step[i][j] = step[i][0]*step[i][0];
////                    }
////                }
//
//
//            }
//        }
//        return step;
//    }
//
//    public static boolean armstrong(long N){
//         long n = N;
//         int c = ("" + n).length();
//        int sum = 0;
//
//        long b = n % 10;
//        while (n >= 1) {
//            if(b != 0){
//                sum += longsstep[(int) b-1][c-1];
//            }
//            n /= 10;
//            b = n % 10;
//        }
//
//        return sum == N;
//    }
//
//
//        public static long[] getNumbers(long N) {
//if(N <= 0){
//    return null;
//}
//        long[] result = null;
//            for (long i = N-1; i > 0; i--) {
//                if(armstrong(i)){
//                    longs.add(i);
//                }
//            }
//
//
//        result = new long[longs.size()];
//        int i = 0;
//        for (long l:longs) {
//            result[i++] = l;
//        }
//        return result;
//    }
//
//
//
////    private static void numbers(long N){
////        long n = N-1;
////        if (n > 0) {
////            String s = Long.toString(n);
////            long[] number = new long[s.length()];
////            for (int i = s.length() - 1; i >= 0; i--) {
////                number[i] = n % 10;
////                n /= 10;
////            }
////            long sum = 0;
////            if(number.length > 1) {
////            for (long value : number) {
////                long l = value;
////
////                    for (int j = 0; j < number.length - 1; j++) {
////                        l *= value;
////                    }
////
////                sum += l;
////            }
////            }else {
////                sum = number[0];
////            }
////            if (sum == (N-1)) {
////                longs.add(sum);
////            }
////            numbers(--N);
////        }
////    }
////
////    public static long[] getNumbers(long N) {
////        long[] result = null;
////        numbers(N);
////        result = new long[longs.size()];
////        int i = 0;
////        for (long l:longs) {
////            result[i++] = l;
////        }
////        return result;
////    }
//
//    public static void main(String[] args) {
//        Long t0 = System.currentTimeMillis();
////        long[] numbers = getNumbers(Long.MAX_VALUE);
//        //long[] numbers = getNumbers(1000);
////        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
//        System.out.println(Arrays.toString(getNumbers(1000)));
//        Long t1 = System.currentTimeMillis();
//        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
//        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
//
//
//
////        System.out.println(Arrays.toString(getNumbers(124)));
// //       System.out.println(Arrays.toString(getNumbers(11)));
////        System.out.println(Arrays.toString(getNumbers(4898)));
////        System.out.println(Arrays.toString(getNumbers(4898)));
////        System.out.println();
//
////        long a = System.currentTimeMillis();
////        System.out.println(Arrays.toString(getNumbers(1000)));
////        long b = System.currentTimeMillis();
////        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
////        System.out.println("time = " + (b - a) / 1000);
//
//
//
////        System.out.println(Long.MAX_VALUE);
////        System.out.println(Arrays.deepToString(initStep()));
////        System.out.println(Arrays.deepToString(longsstep));
//
////
////
////        System.out.println(Arrays.toString(getNumbers(1101101)));
////        System.out.println(123%10);
////
////
//
////        System.out.println();
//
////        a = System.currentTimeMillis();
////        System.out.println(Arrays.toString(getNumbers(1000000)));
////        b = System.currentTimeMillis();
////        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
////        System.out.println("time = " + (b - a) / 1000);
//    }


    private static long S;
    private static int N;
    private static int[] digitsMultiSet;
    private static int[] testMultiSet;

    private static List<Long> results;
    private static long maxPow;
    private static long minPow;

    private static long[][] pows;

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }

    public static long[] getNumbers(long upperLimit) {
        if (upperLimit <= 1) return new long[0];

        S = upperLimit;
        List<Long> armstrongList = generate(String.valueOf(S).length() + 1);
        long[] result = new long[armstrongList.size()];

        for (int i = 0; i < armstrongList.size(); i++) {
            result[i] = armstrongList.get(i);
        }
        return result;
    }

    private static void genPows(int N) {
        if (N > 20) throw new IllegalArgumentException();
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }

    private static boolean check(long pow) {
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;

        for (int i = 0; i < 10; i++) {
            testMultiSet[i] = 0;
        }

        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            if (testMultiSet[i] > digitsMultiSet[i]) return false;
            pow = pow / 10;
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }

        return true;
    }

    private static void search(int digit, int unused, long pow) {
        if (pow >= maxPow) return;

        if (digit == -1) {
            if (check(pow) && pow < S) results.add(pow);
            return;
        }

        if (digit == 0) {
            digitsMultiSet[digit] = unused;
            search(digit - 1, 0, pow + unused * pows[digit][N]);
        } else {
            // Check if we can generate more than minimum
            if (pow + unused * pows[digit][N] < minPow) return;

            long p = pow;
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit - 1, unused - i, p);
                if (i != unused) {
                    p += pows[digit][N];
                    // Check maximum and break the loop - doesn't help
                    // if (p >= maxPow) break;
                }
            }
        }
    }

    private static List<Long> generate(int maxN) {
        if (maxN >= 21) throw new IllegalArgumentException();

        genPows(maxN);
        results = new ArrayList<>();
        digitsMultiSet = new int[10];
        testMultiSet = new int[10];

        for (N = 1; N < maxN; N++) {
            minPow = (long) Math.pow(10, N - 1);
            maxPow = (long) Math.pow(10, N);

            search(9, N, 0);
        }

        Collections.sort(results);

        return results;
    }

}
/*
153/10
 10   15

 53
-150
 3


 120
*/