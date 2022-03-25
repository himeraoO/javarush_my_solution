package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {
   static int countd = 0;
   static int countf = 0;
   static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();


        if (!Files.isDirectory(Paths.get(s))){
            System.out.println(s + " - не папка");
        //    System.exit(1);
        } else {
            Files.walkFileTree(Paths.get(s), new SimpleFileVisitor<Path>(){

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    countd++;
                    return super.preVisitDirectory(dir, attrs);
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    countf++;
                    size += Files.size(file);
                    return super.visitFile(file, attrs);
                }
            });
            System.out.println("Всего папок - " + (countd - 1));
            System.out.println("Всего файлов - " + countf);
            System.out.println("Общий размер - " + size);
        }



    }
}
