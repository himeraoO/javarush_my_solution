package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String str = buff.readLine();
        buff.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));

            while (bufferedReader.ready()){
                int c = 0;
                String begin = bufferedReader.readLine();
                String[] strings = begin.split(" ");
                for (String s:strings) {
                    if(words.contains(s)){
                        c++;
                    }
                }
                if(c == 2){
                    System.out.println(begin);
                }
            }
        bufferedReader.close();
    }
}
