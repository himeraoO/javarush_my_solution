package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

import java.io.BufferedReader;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int i = 0;
        int j = 0;
       while (i < 10){
           while (j < 10){
               System.out.print("S");
               j++;
           }
          j = 0;
           System.out.println();
           i++;
       }

    }
}
