package com.javarush.task.task04.task0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Количество дней в году
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int nYear = Integer.parseInt(s);

        if(nYear%400==0 & nYear%100==0){
            System.out.println("количество дней в году: 366");
        }
        else if (nYear%4==0 & nYear%100!=0){
            System.out.println("количество дней в году: 366");
        }
        else System.out.println("количество дней в году: 365");

    }
}