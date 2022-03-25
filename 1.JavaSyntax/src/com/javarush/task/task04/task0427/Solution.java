package com.javarush.task.task04.task0427;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Описываем числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int i = Integer.parseInt(s);
        int f = i % 2;
        int l = s.length();

        if (i >= 1 & i <= 999) {
            if (f == 0) {
                if (l == 1) {
                    System.out.println("четное однозначное число");
                }
                if (l == 2) {
                    System.out.println("четное двузначное число");
                }
                if (l == 3) {
                    System.out.println("четное трехзначное число");
                }

            } else {
                if (l == 1) {
                    System.out.println("нечетное однозначное число");
                }
                if (l == 2) {
                    System.out.println("нечетное двузначное число");
                }
                if (l == 3) {
                    System.out.println("нечетное трехзначное число");
                }

            }

        }else {

        }
    }
}
