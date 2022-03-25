package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String number1 =bufferedReader.readLine();
        String number2 =bufferedReader.readLine();
        int i1 = Integer.parseInt(number1);
        int i2 = Integer.parseInt(number2);
        if((i1 <= 0)||(i2 <= 0)) {
            throw new IllegalArgumentException();
        }
        System.out.println(nod(i1,i2));
      //  System.out.println(srnod(i1, i2));


    }

    public static int nod(int a,int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }

//    public static int srnod(int a, int b){
//        while (a != 0 && b != 0){
//            if (a > b){
//                a = a % b;
//            }else {
//                b = b % a;
//            }
//        }
//        return a + b;
//    }
}
