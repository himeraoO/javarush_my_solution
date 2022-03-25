package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;


/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]))) {
            ArrayList<String> arrayList = new ArrayList<>();
            while (bufferedReader.ready()) {
                String[] s = bufferedReader.readLine().split(" ");
                for (String s1 : s) {
                    if (s1.matches(".*\\d+.*")) {
                        arrayList.add(s1);
                    }
                }
            }
            String str = String.join(" ", arrayList);
            bufferedWriter.write(str);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
