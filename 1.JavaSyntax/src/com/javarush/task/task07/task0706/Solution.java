package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        int [] a = new int[15];
        int e = 0;
        int o = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 15; i++) {
            a[i] = Integer.parseInt(bufferedReader.readLine());
        }
        for (int i = 0; i < 15; i++) {
            if (i%2 == 0){
                e += a[i];

            } else {
                o += a[i];

            }
        }
        if (e > o){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }else System.out.println("В домах с нечетными номерами проживает больше жителей.");

    }
}
