package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();

            ArrayList<Character> characters = new ArrayList<>();

            FileReader fileReader = new FileReader(s1);
            while (fileReader.ready()){
                characters.add((char) fileReader.read());
            }
            fileReader.close();

            FileWriter fileWriter = new FileWriter(s2);
            for (int i = 1; i < characters.size(); i += 2) {
                fileWriter.write(characters.get(i));
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
