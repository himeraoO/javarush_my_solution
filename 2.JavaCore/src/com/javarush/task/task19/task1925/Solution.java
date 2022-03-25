package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        
        FileReader file1 = new FileReader(args[0]);
        FileWriter file2 = new FileWriter(args[1]);
        
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        
       while(file1.ready()){
           sb.append((char)file1.read());
       }
       
         String [] s = sb.toString().replaceAll("\\s", " ").split(" ");
         
       //  String prefix = "";
         
       for(int i = 0; i < s.length; i++){
           if(s[i].length() > 6){
             //  sb1.append(prefix);
              // prefix = ",";
               sb1.append(s[i]);
                sb1.append(",");
                   
           }
       }
       
     sb1.deleteCharAt(sb1.lastIndexOf(","));
     
       file2.write(sb1.toString());
       
       file1.close();
       file2.close();

    }
}
