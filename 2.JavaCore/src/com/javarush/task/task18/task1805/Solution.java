package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(s);
        HashSet<Integer> integersHashSet = new HashSet<>();
        int b = 0;
        while (fileInputStream.available() > 0){
            b = fileInputStream.read();
            integersHashSet.add(b);
        }
        fileInputStream.close();
        bufferedReader.close();
          ArrayList<Integer> arrayList = new ArrayList<>(integersHashSet);

        Collections.sort(arrayList);
        for (Integer integer: arrayList) {
                System.out.print(integer + " ");

        }

    }
}
