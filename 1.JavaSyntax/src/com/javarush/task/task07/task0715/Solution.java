package com.javarush.task.task07.task0715;

import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");
        
        for (int i = 1; i < list.size(); i++){
            
             list.add(i,"именно");
             i++;
        }
        list.add("именно");
        
       
         for (String s: list
             ) {
            System.out.println(s);
        }
    }
}
