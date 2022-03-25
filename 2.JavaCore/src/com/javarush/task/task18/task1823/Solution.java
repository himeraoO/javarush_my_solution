package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = bufferedReader.readLine()).equals("exit")){
            ReadThread readThread = new ReadThread(s);
            readThread.start();
        }
        bufferedReader.close();

    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            super();
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try(FileInputStream inputStream = new FileInputStream(fileName)) {
               Map<Integer, Integer> map = new HashMap<>();
                while (inputStream.available() > 0){
                 int i =  inputStream.read();
                 if (map.containsKey(i)){
                     map.put(i, map.get(i)+1);
                 }else {
                     map.put(i, 1);
                 }
                }
                int max = Collections.max(map.values());
                for (Map.Entry<Integer, Integer> p: map.entrySet()) {
                    if(max == p.getValue()){
                        synchronized (resultMap){
                            resultMap.put(fileName, p.getKey());
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
