package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Map <String, Integer> map1 = new HashMap<>();
        for (String name : map.values()) {
            if (map1.containsKey(name)) {
                int i = map1.get(name);
                map1.put(name, i+1);
            } else {
                map1.put(name, 1);
            }
        }

        for (Map.Entry<String, Integer> e : map1.entrySet()) {
              if(e.getValue() > 1) {
                  removeItemFromMapByValue(map, e.getKey());
              }
        }


//        for (String name:map.values()) {
//            int count = 0;
//            for (String n: map.values()) {
//                if (n.equals(name))
//                    count++;
//            }
//
//            removeItemFromMapByValue(map, name);

//        }


    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
