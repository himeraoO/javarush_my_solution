package com.javarush.task.task19.task1913;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Выводим только цифры
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
 //создаем адаптер к классу PrintStream
 PrintStream stream = new PrintStream(outputStream);
 //Устанавливаем его как текущий System.out
 System.setOut(stream);

 //Вызываем функцию, которая ничего не знает о наших манипуляциях
 testString.printSomething();

 //Преобразовываем записанные в наш ByteArray данные в строку
 String result = outputStream.toString();

 //Возвращаем все как было
 System.setOut(consoleStream);

System.out.println(result.replaceAll("\\D",""));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
