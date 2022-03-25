package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 450);
        map.put("2", 4500);
        map.put("3", 4050);
        map.put("4", 4501);
        map.put("5", 450);
        map.put("6", 420);
        map.put("7", 430);
        map.put("8", 440);
        map.put("9", 450);
        map.put("0", 456);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        map.values().removeIf(i -> i < 500);
    }

    public static void main(String[] args) {

    }
}