package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties(
                "4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties(
                "4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties(
                "4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        String[] strings = fileName.split(File.separator);
        String word = strings[strings.length - 1];
        String ends = "";
        if(word.contains(".")){
            ends = word.split("\\.")[word.split("\\.").length - 1];
        }

        File file;
        Properties properties;

        switch (ends){
//            case "txt" : file = new File(fileName);
//                properties = new Properties();
//                try {
//                    properties.load(new FileReader(file));
//                } catch (IOException e) {
//                    return properties;
//                }
//                break;
            case "xml" : file = new File(fileName);
                properties = new Properties();
                try {
                    properties.loadFromXML(new FileInputStream(file));
                } catch (IOException e) {
                    return properties;
                }
                break;
            default: file = new File(fileName);
                properties = new Properties();
                try {
                    properties.load(new FileReader(file));
                } catch (IOException e) {
                    return properties;
                }
        }
        return properties;
    }
}
