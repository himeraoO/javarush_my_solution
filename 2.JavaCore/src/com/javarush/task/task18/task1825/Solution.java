package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s;
            while (!(s = bufferedReader.readLine()).equals("end")) {
                arrayList.add(s);
            }
            s = arrayList.get(0);
            String[] st = s.split("\\.part");
            String fileName = st[0];
            TreeSet<String> treeSet = new TreeSet<>(arrayList);

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                for (String p:treeSet) {
                    try (FileInputStream fileInputStream = new FileInputStream(p)) {
                        byte[] bytes = new byte[1000];
                        while (fileInputStream.available() > 0) {
                            int bytesRead = fileInputStream.read(bytes);
                            fileOutputStream.write(bytes, 0, bytesRead);
//                            fileOutputStream.write(fileInputStream.read(bytes));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
