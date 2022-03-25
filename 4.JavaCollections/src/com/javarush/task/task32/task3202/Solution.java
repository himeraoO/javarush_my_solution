package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
if (is != null) {
    final int bufferSize = 1024;
    final char[] buffer = new char[bufferSize];
    //    final StringBuilder out = new StringBuilder();
    Reader in = new InputStreamReader(is, "UTF-8");
    for (; ; ) {
        int l = in.read(buffer, 0, buffer.length);
        if (l < 0)
            break;
        writer.write(buffer, 0, l);
    }
}

//      //  ByteArrayOutputStream result = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int length;
//        while ((length = is.read(buffer)) != -1) {
//            writer.w
//        }
        return writer;
    }
}
