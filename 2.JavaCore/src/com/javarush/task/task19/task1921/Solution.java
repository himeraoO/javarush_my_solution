package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {

            while (bufferedReader.ready()){
                String begin = bufferedReader.readLine();
                String[] parse = begin.split(" ");
                int d = Integer.parseInt(parse[parse.length - 3]);
                int m = Integer.parseInt(parse[parse.length - 2]) - 1;
                int y = Integer.parseInt(parse[parse.length - 1]);

                Calendar calendar = new GregorianCalendar(y, m, d);
                Date date = calendar.getTime();

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < parse.length - 3; i++) {
                    sb.append(parse[i]).append(" ");
                }
//                sb.deleteCharAt(sb.lastIndexOf(" "));
                PEOPLE.add(new Person(sb.toString().trim(), date));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
