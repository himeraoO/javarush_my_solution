package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String,String> map = new HashMap<>();
        map.put("hjfgh","fjjh");
        map.put("dfhgfj","uiuk");
        map.put("dxgvxg","gjhgjgh");
        map.put("dthfh","gjfgj");
        map.put("nnn","ykytkg");
        map.put("nnnb","rhdydtrgh");
        map.put("oo","ffff");
        map.put("bxfbh","ffff");
        map.put("fjgyjgyh","kjhkgj");
        map.put("sdgfdg","htfhtgf");
        return map;

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (String n: map.values()) {
            if (n.equals(name))
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        for (String n: map.keySet()) {
            if (n.equals(lastName))
               return 1;
        }
        return 0;

    }

    public static void main(String[] args) {

    }
}
