package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        InputStream inStream = new FileInputStream(s);
        BufferedInputStream buffer = new BufferedInputStream(inStream);

        while(buffer.available()>0) {
            char c = (char) buffer.read();
            System.out.print(c);
        }


        buffer.close();
        inStream.close(); //закрываем потоки
        reader.close();
    }
}