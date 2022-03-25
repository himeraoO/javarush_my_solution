package com.javarush.task.task04.task0441;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Как-то средненько
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(bufferedReader.readLine());
        int i2 = Integer.parseInt(bufferedReader.readLine());
        int i3 = Integer.parseInt(bufferedReader.readLine());
/*
* 3
* 2
* 1
* */
        if (i1 > i2 & i1 < i3){
            System.out.println(i1);
        }
        if (i1 < i2 & i1 > i3){
            System.out.println(i1);
        }
        if (i2 > i1 & i2 < i3){
            System.out.println(i2);
        }
        if (i2 < i1 & i2 > i3){
            System.out.println(i2);
        }
        if (i3 > i2 & i3 < i1){
            System.out.println(i3);
        }
        if (i3 < i2 & i3 > i1){
            System.out.println(i3);
        }
        if(i1 == i2 && i1 > i3){
            System.out.println(i1);
        }
        if(i1 == i2 && i1 < i3){
            System.out.println(i1);
        }
        if ((i1 == i3 && i1 < i2)){
            System.out.println(i1);
        }
        if ((i1 == i3 && i1 > i2)){
            System.out.println(i1);
        }
        if ((i2 == i3 && i2 < i1)){
            System.out.println(i2);
        }
        if ((i2 == i3 && i2 > i1)){
            System.out.println(i2);
        }
        if(i1 == i2 && i1 == i3){
            System.out.println(i1);
        }
    }
}
