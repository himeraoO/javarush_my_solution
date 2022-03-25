package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        strings = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
           strings.add(bufferedReader.readLine());
            
        }
//        Collections.sort(strings,new Comparator<String>(){
//            public int compare(String s1, String s2){
//                return s1.length() - s2.length();
//            }
//        });
        int l = 0;

        for (int i = 0; i < strings.size() ; i++) {
            if(l < strings.get(i).length()){
                l = strings.get(i).length();
            }
        }
        for (int i = 0; i < strings.size() ; i++) {
             if (l == strings.get(i).length()){
                 System.out.println(strings.get(i));
             }

        }

    }
}

