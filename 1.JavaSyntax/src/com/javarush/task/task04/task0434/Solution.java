package com.javarush.task.task04.task0434;

/* 
Таблица умножения Ӏ Java Syntax: 4 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int i = 1;
        int j = 1;

        while (i <= 10){
            while (j <= 10){
                System.out.print(i*j + " ");
                j++;
            }
            j = 1;
            System.out.println();
            i++;
        }

    }
}
