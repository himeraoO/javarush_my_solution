package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        char c = ',';
//        System.out.println((byte)c); // 44
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(s);
        int i = 0;
        int count = 0;
       while (fileInputStream.available() > 0){
           i = fileInputStream.read();
           if(i == 44){
               count++;
           }
       }
       fileInputStream.close();
       bufferedReader.close();
        System.out.println(count);
    }
}
