package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        String s3 = bufferedReader.readLine();
        bufferedReader.close();

        FileOutputStream fileOutputStream = new FileOutputStream(s1);
        FileInputStream fileInputStream = new FileInputStream(s2);
        FileInputStream fileInputStream2 = new FileInputStream(s3);

        while (true){
            if(fileInputStream.available() > 0){
                fileOutputStream.write(fileInputStream.read());
            }else {
                if (fileInputStream2.available() > 0){
                    fileOutputStream.write(fileInputStream2.read());
                }else {
                    break;
                }
            }
        }
//        byte[] buffer = new byte[fileInputStream.available()];
//        fileOutputStream.write(fileInputStream.read(buffer));
        fileInputStream.close();
     //   fileOutputStream.write("/n".getBytes());
//        buffer = new byte[fileInputStream2.available()];
//        fileOutputStream.write(fileInputStream2.read(buffer));
        fileInputStream2.close();
        fileOutputStream.close();

    }
}
