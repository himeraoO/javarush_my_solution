package com.javarush.task.task18.task1817;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader(args[0])) {
            int count = 0;
            int countS = 0;
            while (reader.ready()){
                Character character = (char) reader.read();
                count++;
                if (character.equals(' ')){
                    countS++;
                }
            }

            double d = (countS / (double) count) * 100;
            String result = String.format("%.2f",d);
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
