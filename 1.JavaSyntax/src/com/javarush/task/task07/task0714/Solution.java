package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );
    ArrayList<String> list = new ArrayList<String>() ;
    for (int i = 0; i < 5; i++) {
          
       String s = reader.readLine();
        list.add(s);
    }
    
    list.remove(2);
    Collections.reverse(list);
    
    for (String s: list
             ) {
            System.out.println(s);
        }
    }
}
