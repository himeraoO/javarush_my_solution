package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Номер месяца
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        List<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        if(months.contains(s)){
            for (int i = 0; i < months.size(); i++) {
                String str = months.get(i);
                if (str.equals(s)){
                    int m = i + 1;
                    System.out.println(months.get(i) +
                            " is the " +
                            m +
                            " month");
                }
            }
        }
    }
}
