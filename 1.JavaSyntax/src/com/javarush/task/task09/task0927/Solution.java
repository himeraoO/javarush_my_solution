package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<>();
        map.put("kjhfghj", new Cat("kjhfghj"));
        map.put("kjhffhg", new Cat("kjhffhg"));
        map.put("kjhdffg", new Cat("kjhdffg"));
        map.put("kjhffghg", new Cat("kjhffghg"));
        map.put("kjhkjfg", new Cat("kjhkjfg"));
        map.put("kjhhnnncfg", new Cat("kjhhnnncfg"));
        map.put("kjjlhfg", new Cat("kjjlhfg"));
        map.put("kjkljhrtryfg", new Cat("kjkljhrtryfg"));
        map.put("kjhukukfg", new Cat("kjhukukfg"));
        map.put("kjhf,klg", new Cat("kjhf,klg"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        return new HashSet<>(map.values());
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
