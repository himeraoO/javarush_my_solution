package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
public static CanFly result;

    static {
        try{
        reset();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        //add your code here - добавьте код тут
    }

    

    public static void reset() throws IOException{
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //add your code here - добавьте код тут
        if(s.equals("helicopter")){
            Solution.result = new Helicopter();
        }
        if(s.equals("plane")){
            
            int i = Integer.parseInt(reader.readLine());
            
            Solution.result = new Plane(i);
        }
        
        reader.close();
    }
}
