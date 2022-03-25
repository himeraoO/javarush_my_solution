package com.javarush.task.task18.task1816;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader(args[0])) {
//            Set<String> characters = new HashSet<>();
            int count = 0;
            String matches = "[A-Za-z]";
            int character = 0;
            while (( character = reader.read()) != -1){
                String s = String.valueOf((char) character);
                if(s.matches(matches)){
//                    characters.add(s);
                    count++;
                }
            }
//            System.out.println(characters.size());
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
