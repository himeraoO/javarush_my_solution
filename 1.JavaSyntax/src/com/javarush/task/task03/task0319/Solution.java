package com.javarush.task.task03.task0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Предсказание на будущее
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        String n1 = bufferedReader.readLine();
        String n2 = bufferedReader.readLine();
        int nn = Integer.parseInt(n1);
        int nnn = Integer.parseInt(n2);

        System.out.println(s +" получает " + nn +" через " + nnn +" лет.");

    }
}
