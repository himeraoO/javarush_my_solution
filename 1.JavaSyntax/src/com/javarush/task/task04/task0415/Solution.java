package com.javarush.task.task04.task0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Правило треугольника
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        String s3 = bufferedReader.readLine();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);

        int i1 = a + b;
        int i2 = b + c;
        int i3 = a + c;

        if ((i1 <= c) || (i2 <= a) || (i3 <= b)){
            System.out.println("Треугольник не существует.");
        }else {
            System.out.println("Треугольник существует.");
        }

    }
}