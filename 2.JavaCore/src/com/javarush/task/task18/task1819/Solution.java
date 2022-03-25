package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();

            FileInputStream fileInputStream = new FileInputStream(s1);
            FileInputStream fileInputStream2 = new FileInputStream(s2);
            byte[] bytesBuffer = new byte[fileInputStream.available()];
            while (fileInputStream.available() > 0){
                fileInputStream.read(bytesBuffer);
            }
            fileInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(s1);
            while (true){
                if(fileInputStream2.available() > 0){
                    fileOutputStream.write(fileInputStream2.read());
                }else {
                    fileOutputStream.write(bytesBuffer);
                    break;
                }
            }
            fileInputStream2.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
