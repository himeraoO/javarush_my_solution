package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) {

        TreeMap<String, File> map = new TreeMap<>();

        Queue<File> queue = new PriorityQueue<>();

        File file = new File(args[0]);

        queue.addAll(Arrays.asList(file.listFiles()));

        while (!queue.isEmpty()) {
            File f = queue.poll();
            if (f.isDirectory()) {
                for (File file1 : f.listFiles())
                    queue.offer(file1);
            } else {
                if(f.length() <= (byte) 50) {
                    map.put(f.getName(), f);
                }
            }
        }

        File fOuter = new File(args[1]);
        File dest = new File(fOuter.getParent() + "/" + "allFilesContent.txt");
//        File dest = new File("allFilesContent.txt");
//        if(FileUtils.isExist(dest)){
//        if(FileUtils.isExist(fOuter)){
            FileUtils.renameFile(fOuter, dest);
//        }

//        try (FileOutputStream fileOutputStream = new FileOutputStream(fOuter)) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
            for (File f : map.values()) {
                fileOutputStream.write(Files.readAllBytes(f.toPath()));
                fileOutputStream.write('\n');
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
