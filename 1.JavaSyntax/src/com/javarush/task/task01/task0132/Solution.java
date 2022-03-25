package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        char [] chars = String.valueOf(number).toCharArray();
       int i =0;
        for (char c : chars) {
            i += Character.getNumericValue(c);
        }

        return i;
    }
}