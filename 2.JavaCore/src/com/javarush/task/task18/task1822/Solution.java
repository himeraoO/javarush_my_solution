package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {

        try( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();

            FileReader reader1 = new FileReader(s);

            BufferedReader bufferedReader = new BufferedReader(reader1);

            while (bufferedReader.ready()){
                String str = bufferedReader.readLine();
                String [] strings = str.split(" ");
                if(args[0].equals(strings[0])){
                    System.out.println(str);
                }
            }
            bufferedReader.close();
            reader1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
