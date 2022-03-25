package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
        int key = 0;
        switch (args[0]){
            case "-e" :
                key = 1;
                break;
            case "-d" :
                key = -1;
                break;
        }
        while (fileInputStream.available() > 0){
            int i = fileInputStream.read();
            fileOutputStream.write(i + key);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
