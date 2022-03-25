package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        while (!s.equals("exit")){
            if(Character.isLetter(s.toCharArray()[0])) {
                print(s);
            }else {
                if (s.contains(".")) {
                    print(Double.parseDouble(s));
                } else if (Integer.parseInt(s) > 0 && Integer.parseInt(s) < 128 && !s.contains(".")) {
                    print(Short.parseShort(s));
                } else if (Integer.parseInt(s) <= 0 || Integer.parseInt(s) >= 128) {
                    print(Integer.parseInt(s));
                }
            }
            s = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
