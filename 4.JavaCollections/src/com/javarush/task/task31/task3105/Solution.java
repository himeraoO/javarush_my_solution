package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File fileName = new File(args[0]);

       ZipInputStream zip = new ZipInputStream(new FileInputStream(args[1]));
       ZipOutputStream zipo = new ZipOutputStream(new FileOutputStream(args[1]));

//       List<ZipEntry> list = new ArrayList<>();
        Map<String, ByteArrayOutputStream> map = new HashMap<>();

        while (true) {
            ZipEntry entry = zip.getNextEntry();
            if (entry == null) break;

//            list.add(entry);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (OutputStream os = new BufferedOutputStream(byteArrayOutputStream)) {
                final int bufferSize = 1024;
                byte[] buffer = new byte[bufferSize];
                for (int readBytes; (readBytes = zip.read(buffer, 0, bufferSize)) > -1; ) {
                    os.write(buffer, 0, readBytes);
                }
                os.flush();
            }
            map.put(entry.getName(), byteArrayOutputStream);
        }
        zip.close();

        ZipEntry file = new ZipEntry("new/" + fileName.getName());
        zipo.putNextEntry(file);
        Files.copy(fileName.toPath(), zipo);

//        for (ZipEntry z: list) {
//            zipo.putNextEntry(z);
//        }

        for (String s:map.keySet()) {
            if(!s.equals(file.getName())) {
                ZipEntry fileX = new ZipEntry(s);
                zipo.putNextEntry(fileX);
//            Files.copy(, zipo);
                zipo.write(map.get(s).toByteArray());
            }
        }

        zipo.close();



    }
}
