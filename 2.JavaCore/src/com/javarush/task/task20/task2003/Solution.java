package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
//        PrintWriter printWriter = new PrintWriter(outputStream);

        Properties properties = new Properties();

        if (!runtimeStorage.isEmpty()){
            for (Map.Entry<String, String> p:runtimeStorage.entrySet()) {
//                printWriter.println(p.getKey() + "=" + p.getValue());
                properties.setProperty(p.getKey(), p.getValue());
            }
            properties.store(outputStream,"=");
        }
//        printWriter.close();
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties properties = new Properties();
        properties.load(inputStream);
        if (!properties.isEmpty()){
            for (Map.Entry<Object, Object> p:properties.entrySet()) {
                runtimeStorage.put((String)p.getKey(), (String)p.getValue());
            }
        }
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        while (bufferedReader.ready()){
//            String s = bufferedReader.readLine();
//            String[] strings = s.split("=");
//
//        }

    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
