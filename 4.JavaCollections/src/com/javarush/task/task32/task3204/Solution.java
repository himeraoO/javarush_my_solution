package com.javarush.task.task32.task3204;

import java.io.*;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {

        char [] chars = new char[8];

        String ch = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
        Random rnd = new Random();
        String s = "";

        while (true) {
            for (int i = 0; i < chars.length; i++) {
                chars[i] = ch.charAt(rnd.nextInt(ch.length()));
            }

            s = new String(chars);
//            System.out.println(s);
//            System.out.println(s.matches(".*\\d.*"));
//            System.out.println(s.matches(".*[a-z].*"));
//            System.out.println(s.matches(".*[A-Z].*"));
            if ((s.matches(".*\\d.*")) && (s.matches(".*[a-z].*")) && (s.matches(".*[A-Z].*"))){
               // System.out.println(s);
                break;
            }
        }

        InputStream inputStream = new ByteArrayInputStream(s.getBytes());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BufferedInputStream bis = new BufferedInputStream(inputStream);
        while (bis.available() > 0)
        {
            int data = bis.read();
            outputStream.write(data);
        }

        bis.close();
        inputStream.close();

        return outputStream;
    }
}
