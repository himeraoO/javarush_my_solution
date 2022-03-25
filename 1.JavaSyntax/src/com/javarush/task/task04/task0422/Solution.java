package com.javarush.task.task04.task0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
18+
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        String age = bufferedReader.readLine();

        int age1 = Integer.parseInt(age);

        if (age1 < 18){
            System.out.println("Подрасти еще");
        }

    }
}
