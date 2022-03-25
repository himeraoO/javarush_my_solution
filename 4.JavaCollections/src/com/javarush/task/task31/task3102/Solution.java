package com.javarush.task.task31.task3102;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        
        Queue<File> queue = new PriorityQueue<>();

        File file = new File(root);

        queue.addAll(Arrays.asList(file.listFiles()));

            while (!queue.isEmpty()) {
	            File f = queue.poll();
	            if (f.isDirectory()) {
	            	for (File file1 : f.listFiles())
		            	queue.offer(file1);
            	} else
		            list.add(f.getAbsolutePath());
        }
            return list;
    }

    public static void main(String[] args) {

    }
}
