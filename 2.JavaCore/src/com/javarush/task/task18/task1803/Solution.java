package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(s);
        HashMap<Integer,Integer> byteIntegerHashMap = new HashMap<>();
        int b = 0;
//        while ((b = fileInputStream.read()) != -1){
        while (fileInputStream.available() > 0){
            b = fileInputStream.read();
            if(!byteIntegerHashMap.containsKey(b)){
                byteIntegerHashMap.put(b,1);
            }else {
                int i = byteIntegerHashMap.get(b);
                byteIntegerHashMap.put(b, i + 1);
            }
        }
        fileInputStream.close();
        bufferedReader.close();
      //  ArrayList<Integer> arrayList = new ArrayList<>(byteIntegerHashMap.values());
      //  int i = Collections.max(arrayList);
        int i = Collections.max(byteIntegerHashMap.values());
        for (Map.Entry<Integer, Integer> pair: byteIntegerHashMap.entrySet()) {
            if (i == pair.getValue()){
                System.out.print(pair.getKey() + " ");
            }
        }

    }
}
