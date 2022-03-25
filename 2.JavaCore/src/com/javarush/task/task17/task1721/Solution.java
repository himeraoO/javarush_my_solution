package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine();
        String name2 = br.readLine();
        
        // FileReader file1 = new FileReader(name1);
        // FileReader file2 = new FileReader(name2);
        
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(name1));
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader(name2));
                String s = null;
                while ((s = bufferedReader2.readLine()) != null){
                    allLines.add(s);
                }
                bufferedReader2.close();
        String s2 = null;
                while ((s2 = bufferedReader3.readLine()) != null){
                    forRemoveLines.add(s2);
                }
                bufferedReader3.close();
        
       
        Solution s23 = new Solution();
        s23.joinData();
        
        br.close();
       
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }else{
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
