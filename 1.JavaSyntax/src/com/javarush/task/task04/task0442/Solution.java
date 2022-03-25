package com.javarush.task.task04.task0442;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        while (true){
            int n = Integer.parseInt(bufferedReader.readLine());
            i += n;
            if (n == -1){
                break;
            }
        }
        System.out.println(i);

    }
}
