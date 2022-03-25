package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        
        FileReader file = new FileReader(s);
        StringBuilder sb = new StringBuilder();
        
        while(file.ready()){
            sb.append((char)file.read());
        }
        
        file.close();
        reader.close();
        
        String [] str = sb.toString().split("[\\n]");
        
        for(int i = 0; i < str.length; i++){
           System.out.println(new StringBuilder(str[i]).reverse()); 
        }
        
        
    }
}
