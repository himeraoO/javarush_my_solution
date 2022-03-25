package com.javarush.task.task04.task0426;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Ярлыки и числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int i = Integer.parseInt(s);
        int f = i % 2;

        if (i > 0 ){
            if (f == 0){
                System.out.println("положительное четное число");
            }else System.out.println("положительное нечетное число");
        }
        if (i < 0 ){
            if (f == 0){
                System.out.println("отрицательное четное число");
            }else System.out.println("отрицательное нечетное число");
        }
        if (i == 0){
            System.out.println("ноль");
        }


    }
}
