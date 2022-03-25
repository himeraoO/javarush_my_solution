package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(s));

        do{
            s = reader.readLine();
            bufferedWriter.write(s + "\n");
        } while (!s.equals("exit"));

        bufferedWriter.close();
        reader.close();
    }
}
