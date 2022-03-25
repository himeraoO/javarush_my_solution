package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();

            ArrayList<String> strings = new ArrayList<>();

            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(s1));
            while (bufferedReader1.ready()){
                String[] strings1 = bufferedReader1.readLine().split(" ");
                for (String s:strings1) {
                    if (s.matches("\\b\\d+\\b"))
                    strings.add(s);
                }
            }
            bufferedReader1.close();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(s2));
            for (String s:strings) {
                bufferedWriter.write(s);
                bufferedWriter.write(" ");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
