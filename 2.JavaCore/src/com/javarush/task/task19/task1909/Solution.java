package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();

            ArrayList<String> strings = new ArrayList<>();

            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(s1));
            while (bufferedReader1.ready()){
                strings.add(bufferedReader1.readLine());
            }
            bufferedReader1.close();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(s2));
            for (String s:strings) {
                String sNew = s.replace('.', '!');
                bufferedWriter.write(sNew);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
