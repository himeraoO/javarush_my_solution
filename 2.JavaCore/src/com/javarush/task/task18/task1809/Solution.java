package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String s1 = reader.readLine();

        //Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream(s);
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream(s1);

       // byte[] buffer = new byte[1000];
        byte[] buffer = new byte[inputStream.available()];

//        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
//        {
            // прочитать очередной блок байт в переменную buffer и реальное количество в count
            int count = inputStream.read(buffer);

//        }
     //   outputStream.write(buffer, 0, count); //записать блок(часть блока) во второй поток
     //  Collections.reverse(outputStream);
    //    byte[] bufferOut = new byte[buffer.length];
      //  for (int i = buffer.length - 1 , j = 0; i >= 0 && j > buffer.length ; i-- , j++) {
            for (int i = count - 1; i >= 0; i--) {

                // bufferOut[j] = buffer[i];
            outputStream.write(buffer[i]);
        }
       // outputStream.write(bufferOut);


        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();

    }
}
