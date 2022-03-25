package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        ArrayList<String> partFiles = new ArrayList<>();
//        ZipInputStream zipi;
//        FileOutputStream zipFile = new FileOutputStream(args[0]);
//       // ZipOutputStream zip = new ZipOutputStream(zipFile);
//
//        int i = 1;
//
//        while (i < args.length){
////            zipi = new ZipInputStream(new FileInputStream(args[i]));
////            zipi.read();
//            partFiles.add(args[i]);
//            i++;
//        }
//        Collections.sort(partFiles);
//        ByteArrayInputStream
////        C:/pathToTest/test.zip.003
//        String zipArhive = args[1].substring(0,args[1].length()-4);
//        Path p = Files.createFile(Paths.get(zipArhive));
//        FileOutputStream fileOutputStream = new FileOutputStream(zipArhive);
//        for (String s:partFiles) {
////            Files.copy(Paths.get(s), p);
//            try (FileInputStream fileInputStream = new FileInputStream(s)) {
//                byte[] bytes = new byte[1000];
//                while (fileInputStream.available() > 0) {
//                    int bytesRead = fileInputStream.read(bytes);
//                    fileOutputStream.write(bytes, 0, bytesRead);
////                            fileOutputStream.write(fileInputStream.read(bytes));
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        fileOutputStream.close();
//        zipi = new ZipInputStream(new FileInputStream(zipArhive));
////        while (zipi.available() != 0){
////
////        }
////            zipi.read();
//        //////////////////////////////////////////////////
//        ZipEntry entry;
////        String name;
////        long size;
//        while((entry=zipi.getNextEntry())!=null) {
//
////            name = entry.getName();
////            size = entry.getSize();
//
//            for (int c = zipi.read(); c != -1; c = zipi.read()) {
//                zipFile.write(c);
//            }
//            zipFile.flush();
//            zipi.closeEntry();
//            zipFile.close();
//        }
//        //////////////////////////////////////////////////
//
//
////
////
////
////////кладем в него ZipEntry – «архивный объект»
//////        zip.putNextEntry(new ZipEntry("document.txt"));
////
//////копируем файл «document-for-archive.txt» в архив под именем «document.txt»
////        File file = new File("c:/document-for-archive.txt");
////        Files.copy(file.toPath(), zip);
////
////// закрываем архив
////        zip.close();

        File result = new File(args[0]);    //Файл результата, по совместительству имя этого файла мы ищем в архиве
        if (!result.exists()) {
            result.createNewFile();
        }
        List<FileInputStream> fileInputStreams = new ArrayList<>(); //Список входящих стримов из разных кусков архива

        //Расставляем имена файлов архива в нужном нам порядке
        List<String> fileNames = new ArrayList<>();
        fileNames.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileNames);

        //Создаем входящий стрим для каждого куска архива
        for (String name : fileNames) {
            fileInputStreams.add(new FileInputStream(name));
        }

        try (ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams))))    //Входящий стрим общего архива
        {
            while (true) {
                ZipEntry entry = is.getNextEntry();
                if (entry == null) break;

                try (OutputStream os = new BufferedOutputStream(new FileOutputStream(result))) {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for (int readBytes; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                        os.write(buffer, 0, readBytes);
                    }
                    os.flush();
                }
            }
        }
    }
}
