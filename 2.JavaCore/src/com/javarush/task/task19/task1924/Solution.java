package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        String file = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            file = bufferedReader.readLine();
        } catch (IOException e) {
           // e.printStackTrace();
        }
        String line;
        try (BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file))) {

            while ((line = bufferedReader2.readLine()) != null) {
               // String line2 = "";
                for (Map.Entry<Integer,String> p: map.entrySet()) {
//                    line2 = line.replaceAll("\\b" + p.getKey() + "\\b", p.getValue());
                    line = line.replaceAll("\\b" + p.getKey() + "\\b", p.getValue());
                }
//
//                String[] strings = line.split(" ");
//                for (int i = 0; i < strings.length; i++) {
//                    if (strings[i].matches("\\d+")) {
//                        int j = Integer.parseInt(strings[i]);
//                        if (map.containsKey(j)) {
//                            strings[i] = map.get(j);
//                        }
//                    }
//                }
//                String line2 = String.join(" ", strings);
//                System.out.println(line2);
                System.out.println(line);
            }
        } catch (IOException e) {
          //  e.printStackTrace();
        }


    }
}
