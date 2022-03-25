package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(s);
        Scanner scanner = new Scanner(fileInputStream);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNext()){
            int i = scanner.nextInt();
            if (i%2 == 0){
                arrayList.add(i);
            }
        }
        scanner.close();
        fileInputStream.close();
        reader.close();
        Collections.sort(arrayList);
        for (int i:arrayList) {
            System.out.println(i);
        }
    }
}
