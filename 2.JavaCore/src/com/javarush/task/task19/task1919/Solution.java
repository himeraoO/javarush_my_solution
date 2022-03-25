package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))){
            TreeMap<String,Double> treeMap = new TreeMap<>();

            while (bufferedReader.ready()){
                String[] s = bufferedReader.readLine().split(" ");
                if(treeMap.containsKey(s[0])){
                    double d = treeMap.get(s[0]);
                    treeMap.put(s[0], d + Double.parseDouble(s[1]));
                }else {
                    treeMap.put(s[0], Double.parseDouble(s[1]));
                }
            }
            for (Map.Entry<String, Double> p:treeMap.entrySet()) {
                System.out.println(p.getKey() + " " + p.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
