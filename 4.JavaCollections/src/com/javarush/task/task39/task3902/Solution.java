package com.javarush.task.task39.task3902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Биты были биты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long l = Long.parseLong(reader.readLine());
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("The entered number has " + result + "ones");

    }

    public static boolean isWeightEven(long number) {
        
   //     String binary = Long.toBinaryString(number);
        
    //    int index = binary.indexOf("1");
        
        //  char [] arr = binary.toCharArray();
         
        //  int count = 0;
         
        //  for(int i = 0; i < arr.length - 1; i++){
        //  }
        
        int i = Long.bitCount(number);
        if(i%2 == 0){
            return true;
        }
         
        
        return false;
    }
}
