package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.add("kjhg.kjf");
        arrayList.add("kjhg.kjf");
        arrayList.add("kjhg.kjf");
        arrayList.add("kjhg.kjf");
        arrayList.add("kjhg.kjf");
        System.out.println(arrayList.size());
        for (String s:arrayList
             ) {
            System.out.println(s);
        }
    }
}
