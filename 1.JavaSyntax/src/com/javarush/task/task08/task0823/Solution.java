package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        char[] chars = string.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            if (Character.isLetter(chars[0])){
                char ch = chars[0];
                chars[0] = Character.toUpperCase(ch);
            }
            if (Character.isLetter(chars[i]) && (chars[i - 1] == ' ')){
                char ch = chars[i];
                chars[i] = Character.toUpperCase(ch);
            }
        }
        System.out.println(String.valueOf(chars));

//        String [] s = string.split(" ");
//        for(int i = 0; i < s.length; i++){
//            String st = s[i];
//            char [] a = st.toCharArray();
//                a [0] = Character.toUpperCase(a[0]);
//                st = String.valueOf(a);
//                s[i] = st;
//
//        }
//        for(String str: s){
//            System.out.print(str + " ");
//        }
        
        
        // System.out.println(Arrays.toString(s));

        //напишите тут ваш код
    }
}
