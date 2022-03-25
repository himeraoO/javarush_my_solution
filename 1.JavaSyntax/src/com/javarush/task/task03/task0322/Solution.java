package com.javarush.task.task03.task0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Большая и чистая
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        String n2 = bufferedReader.readLine();
        String n3 = bufferedReader.readLine();

        System.out.println(n+ " + "+n2+" + "+n3+" = Чистая любовь, да-да!");

    }
}