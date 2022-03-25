package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
       
       if(s == null || s.isEmpty()){
          return 0; 
       }
       
        char [] arr = s.toCharArray();
       
        List<Integer> list = new ArrayList();
        StringBuilder sb = new StringBuilder();
         sb.append(arr[0]);
         int count = 0; 
      
       for(int i = 0; i < arr.length - 1; i++){
           
            System.out.println(sb);
            
           int result = sb.indexOf(Character.toString(arr[i+1]));
            
            if(result == -1){
                sb.append(arr[i+1]);
            }else{
              list.add(sb.toString().length());
              int index = sb.lastIndexOf(Character.toString(arr[i+1]));
              String str = sb.substring(index+1);
              sb.setLength(0);
              sb.append(str).append(arr[i+1]);
            }
       }
       list.add(sb.toString().length());
       Collections.sort(list);
        
         System.out.println(sb);
         System.out.println(list);
      
        return list.get(list.size()-1);
    }
}
