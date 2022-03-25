package com.javarush.task.task04.task0418;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Минимум двух чисел Ӏ Java Syntax: 4 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String  s1 = bufferedReader.readLine();
        String  s2 = bufferedReader.readLine();
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);

        if (i1 > i2){
            System.out.println(i2);
        } if (i1 < i2){
            System.out.println(i1);
        }if (i1 == i2) {
            System.out.println(i1);
        }

    }
}