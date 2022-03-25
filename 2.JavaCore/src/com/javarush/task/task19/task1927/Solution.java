package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

/* 
Контекстная реклама
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
 
 String s = "JavaRush - курсы Java онлайн";

 String[] result = (outputStream.toString()).split("[\\n]");
 
 ArrayList<String> res = new ArrayList<>();
 
 for(int i = 0; i < result.length-1;i++){
     if(i%2 == 0){
     res.add(result[i]);
     res.add(result[i+1]);
     res.add(s);
     if (i == result.length-3){
     res.add(result[i+2]);
     }
     }
     
 }
 
  //Возвращаем все как было
 System.setOut(consoleStream);
 
 
 for(String s1: res){
     System.out.println(s1);
 }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
