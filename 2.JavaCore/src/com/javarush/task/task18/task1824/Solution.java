package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s;
            while (true) {
                s = bufferedReader.readLine();
                try (FileInputStream fileInputStream = new FileInputStream(s)){

                } catch (FileNotFoundException e) {
                    System.out.println(s);
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
