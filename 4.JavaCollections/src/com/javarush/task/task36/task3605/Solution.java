package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        FileReader reader = new FileReader(filePath);
        TreeSet<Character> treeSet = new TreeSet<>();
        while (reader.ready()){
            char ch = (char) reader.read();
            String s = String.valueOf(ch);
            if(s.matches("[aA-zZ]")){
                treeSet.add(Character.toLowerCase(ch));
            }
        }
        reader.close();
        if (treeSet.size() <= 5) {
            for (Character c: treeSet) {
                System.out.print(c);
            }
        }else {
            for (int i = 0; i < 5; i++) {
                System.out.print(treeSet.pollFirst());
            }
        }

    }
}
