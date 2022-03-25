package com.javarush.task.task04.task0429;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительные и отрицательные числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        int i = Integer.parseInt(s);
        int i2 = Integer.parseInt(s1);
        int i3 = Integer.parseInt(s2);

        if (i > 0 & i2 > 0 & i3 > 0){
            System.out.println("количество отрицательных чисел: 0\n" +
                    "количество положительных чисел: 3");
        }
        if (i < 0 & i2 > 0 & i3 > 0 | i > 0 & i2 < 0 & i3 > 0 | i > 0 & i2 > 0 & i3 < 0){
            System.out.println("количество отрицательных чисел: 1\n" +
                    "количество положительных чисел: 2");
        }
        if (i < 0 & i2 < 0 & i3 > 0 | i < 0 & i2 > 0 & i3 < 0 | i > 0 & i2 < 0 & i3 < 0){
            System.out.println("количество отрицательных чисел: 2\n" +
                    "количество положительных чисел: 1");
        }
        if (i < 0 & i2 < 0 & i3 < 0){
            System.out.println("количество отрицательных чисел: 3\n" +
                    "количество положительных чисел: 0");
        }
        if (i < 0 & i2 == 0 & i3 > 0 | i > 0 & i2 == 0 & i3 < 0 | i == 0 & i2 < 0 & i3 > 0 | i == 0 & i2 > 0 & i3 < 0 | i > 0 & i2 < 0 & i3 == 0 | i < 0 & i2 > 0 & i3 == 0){
            System.out.println("количество отрицательных чисел: 1\n" +
                    "количество положительных чисел: 1");
        }
        if (i < 0 & i2 == 0 & i3 == 0 | i == 0 & i2 < 0 & i3 == 0 | i == 0 & i2 == 0 & i3 < 0 ){
            System.out.println("количество отрицательных чисел: 1\n" +
                    "количество положительных чисел: 0");
        }
        if (i > 0 & i2 == 0 & i3 == 0 | i == 0 & i2 > 0 & i3 == 0 | i == 0 & i2 == 0 & i3 > 0 ){
            System.out.println("количество отрицательных чисел: 0\n" +
                    "количество положительных чисел: 1");
        }
        if (i > 0 & i2 > 0 & i3 == 0 | i == 0 & i2 > 0 & i3 > 0 | i > 0 & i2 == 0 & i3 > 0 ){
            System.out.println("количество отрицательных чисел: 0\n" +
                    "количество положительных чисел: 2");
        }
        if (i < 0 & i2 < 0 & i3 == 0 | i == 0 & i2 < 0 & i3 < 0 | i < 0 & i2 == 0 & i3 < 0 ){
            System.out.println("количество отрицательных чисел: 2\n" +
                    "количество положительных чисел: 0");
        }
    }
}
