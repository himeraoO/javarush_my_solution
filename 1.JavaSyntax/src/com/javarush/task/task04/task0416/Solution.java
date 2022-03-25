package com.javarush.task.task04.task0416;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переходим дорогу вслепую
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        double d = Double.parseDouble(s);
        double n = d % 5;
        if(n < 3){
            System.out.println("зеленый");
        }else if(n >= 3 & n < 4){
            System.out.println("желтый");
        }else if(n >= 4 & n < 5){
            System.out.println("красный");
        }

    }
}