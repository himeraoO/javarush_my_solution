package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int [] a = new int[20];
        int [] b = new int[10];
        int [] c = new int[10];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            a[i] = Integer.parseInt(bufferedReader.readLine());
        }
        for (int i = 0; i < 20; i++) {
           if (i < 10){
               b[i] = a[i];
           }else {
               c[i-10] = a [i];
           }
        }
        for (int i: c) {
            System.out.println(i);
        }
    }
}
