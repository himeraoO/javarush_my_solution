package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.File;
import java.nio.file.Paths;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
//        System.out.println(Paths.get().toFile().exists());
        Class c = Class.forName("ertert445");
    }

    public static void main(String[] args) {

        VeryComplexClass veryComplexClass = new VeryComplexClass();
        try {
            veryComplexClass.veryComplexMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
