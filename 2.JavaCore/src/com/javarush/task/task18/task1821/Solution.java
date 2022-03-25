package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()){
                Character character = (char) reader.read();
                if(map.containsKey(character)){
                    int i = map.get(character);
                    map.put(character, i + 1);
                } else {
                    map.put(character,1);
                }
            }
          List<Character> list = new ArrayList<>(map.keySet());
            Collections.sort(list);
            for (Character p: list) {
                System.out.println(p + " " + map.get(p));
            }

        }catch (IOException e){

        }

    }
}
