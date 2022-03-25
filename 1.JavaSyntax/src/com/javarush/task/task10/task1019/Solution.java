package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String n = reader.readLine();
        int id = 0;
        String name = "";
        HashMap<String, Integer> map = new HashMap<>();
        while (true){
            if(n.isEmpty()){
                break;
            }
            id = Integer.parseInt(n);
            name = reader.readLine();
            map.put(name, id);
            n = reader.readLine();
        }
        for (Map.Entry<String, Integer> m:map.entrySet()) {
            System.out.println(m.getValue() + " " + m.getKey());
        }
    }
}
