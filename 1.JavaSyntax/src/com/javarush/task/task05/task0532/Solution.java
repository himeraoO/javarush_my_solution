package com.javarush.task.task05.task0532;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int temp = n;
        int maximum = 0;
        if (n > 0) {
            if(temp == n){
                maximum = Integer.parseInt(reader.readLine());;
            }
            while ((n-1) > 0) {
                int num = Integer.parseInt(reader.readLine());
                if (maximum < num) {
                    maximum = num;
                }
                n--;
            }
            //напишите тут ваш код

            System.out.println(maximum);
        }
    }
}
