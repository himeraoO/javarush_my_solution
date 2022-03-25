package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        FileInputStream inputStream = null;
            while (!(s = bufferedReader.readLine()).isEmpty()){
                inputStream = new FileInputStream(s);
                if (inputStream.available() < 1000){
                    bufferedReader.close();
                    inputStream.close();
                    throw new DownloadException();
                }
            }
        bufferedReader.close();
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public static class DownloadException extends Exception {

    }
}
