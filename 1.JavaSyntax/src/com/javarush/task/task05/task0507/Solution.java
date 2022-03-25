package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList j = new ArrayList();
        double i = 0;
        while (true) {
            int number = Integer.parseInt(bufferedReader.readLine());

            if (number == -1) {

                break;
            }
            i += number;
            j.add(number);
        }
        System.out.println(i / j.size());
    }
}

