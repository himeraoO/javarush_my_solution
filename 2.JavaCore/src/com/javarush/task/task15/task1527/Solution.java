package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] words = s.split("\\?");
       
        for(int i = 1; i < words.length; i++){
           String[] w = words[i].split("&");
           for(int j = 0; j < w.length; j++){
               if(w[j].contains("=")){
                  String[] o = w[j].split("=");
                  System.out.print(o[0] + " ");
               } else {
                   System.out.print(w[j] + " ");
               }
               
            }
        }
        System.out.println();
        
         for(int i = 1; i < words.length; i++){
           String[] w = words[i].split("&");
           for(int j = 0; j < w.length; j++){
                if(w[j].contains("obj")){
                    String[] o = w[j].split("=");
                  try {
                      double d = Double.parseDouble(o[1]);
                        alert(d);
                  } 
                //   o[1].contains("."){
                  catch(Exception e){
                       alert(o[1]);
                   }
                }
               }
           }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
