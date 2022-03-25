package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
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

        String[] arr = result.split(" ");
        int i1 = Integer.parseInt(arr[0]);
        int i2 = Integer.parseInt(arr[2]);
        int res = 0;

        if (arr[1].equals("+")) {
            res = i1 + i2;
        } else if (arr[1].equals("-")) {
            res = i1 - i2;
        } else {
            res = i1 * i2;
        }

        //Возвращаем все как было
        System.setOut(consoleStream);


        System.out.printf("%s %s %s = %d", arr[0], arr[1], arr[2], res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

