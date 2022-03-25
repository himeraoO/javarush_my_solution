package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();
            String s3 = bufferedReader.readLine();

            FileInputStream fileInputStream = new FileInputStream(s1);
            int size = fileInputStream.available();
            int size2file = 0;
            if(size%2 == 0){
                size2file = size/2;
            }else {
                size2file = (size/2) + 1;
            }

            FileOutputStream fileOutputStream1 = new FileOutputStream(s2);
            FileOutputStream fileOutputStream2 = new FileOutputStream(s3);
            byte[] buffer = new byte[size2file];

                 int c = fileInputStream.read(buffer);
                 fileOutputStream1.write(buffer, 0, c);
                 c = fileInputStream.read(buffer);
                 fileOutputStream2.write(buffer, 0, c);

            fileInputStream.close();
            fileOutputStream1.close();
            fileOutputStream2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
