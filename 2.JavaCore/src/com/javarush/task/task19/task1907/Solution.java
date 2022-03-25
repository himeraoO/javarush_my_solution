package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
            String s1 = bufferedReader.readLine();

            ArrayList<String> strings = new ArrayList<>();

            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(s1));
            while (bufferedReader1.ready()){
//                String[] strings1 = bufferedReader1.readLine().split(",");
                String[] strings1 = bufferedReader1.readLine().split("\\W");
                for (String s:strings1) {
                    strings.add(s.trim());
                }
//                strings.addAll(Arrays.asList(strings1));
            }
            bufferedReader1.close();

            String find = "world";
            int count = 0;
            for (String s:strings) {
                if(find.equals(s)){
                    count++;
                }
            }
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
