package com.javarush.task.task39.task3904;

import java.util.Arrays;

/* 
Лестница
*/

public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        
        if(n < 0){
            return 0;
        }
        
        if(n == 0){
            return 1;
        }
        
        long i = 0;
        long a = 0;
        long b = 0;
        long c = 1;
        long sum_fib = 1;
        
            while(i++ < n){
                sum_fib = a + b + c;
                a = b;
                b = c;
                c = sum_fib;
            }
        
        return sum_fib;

    }
}

