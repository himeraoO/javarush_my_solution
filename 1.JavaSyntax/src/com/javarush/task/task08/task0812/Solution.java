package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        List<Integer> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(bufferedReader.readLine()));
        }

        int c = 1;
        int max = 1;
        int number = list.get(0);


        for (int i = 1; i < 10; i++) {
            if (number == list.get(i)){
                c++;
                if(max < c) {
                    max = c;
                }
            }else {
                number = list.get(i);
                if(max < c) {
                    max = c;
                }
                c = 1;
            }
        }
        System.out.println(max);
    }
}
