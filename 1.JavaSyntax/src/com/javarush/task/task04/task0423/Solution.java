package com.javarush.task.task04.task0423;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Фейс-контроль
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        String age = bufferedReader.readLine();
        int age1 = Integer.parseInt(age);
        if (age1 > 20){
            System.out.println("И 18-ти достаточно");
        }

    }
}
