package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
        int t2 = Integer.parseInt(reader.readLine());
        int t3 = Integer.parseInt(reader.readLine());
        int t4 = Integer.parseInt(reader.readLine());
        int t5 = Integer.parseInt(reader.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(t);
        arrayList.add(t2);
        arrayList.add(t3);
        arrayList.add(t4);
        arrayList.add(t5);

        Collections.sort(arrayList);

        for (int f: arrayList) {
            System.out.println(f);
        }



        //напишите тут ваш код
    }
}
