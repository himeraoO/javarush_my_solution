package com.javarush.task.task04.task0428;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительное число
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
            System.out.println("3");
        }
        if (i <= 0 & i2 > 0 & i3 > 0 | i > 0 & i2 <= 0 & i3 > 0 | i > 0 & i2 > 0 & i3 <= 0){
           System.out.println("2");
        }
        if (i <= 0 & i2 <= 0 & i3 > 0 | i <= 0 & i2 > 0 & i3 <= 0 | i > 0 & i2 <= 0 & i3 <= 0){
            System.out.println("1");
        }
        if (i <= 0 & i2 <= 0 & i3 <= 0){
            System.out.println("0");
        }
//        if (i == 0 & i2 == 0 & i3 == 0){
//            System.out.println("0");
//        }



    }
}
