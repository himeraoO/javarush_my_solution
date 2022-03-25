package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName  = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        int i = text.length();
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        byte [] bytes = new  byte[i];

        raf.seek(number);

       int j = raf.read(bytes,0,i);

        if(new String(bytes).equals(text)){
            raf.seek(raf.length());
            raf.write("true".getBytes());
        } else {
            raf.seek(raf.length());
            raf.write("false".getBytes());
        }

        raf.close();

    }
}
