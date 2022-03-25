package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        List list = new ArrayList();
        list.add("sdgdhdfh");
        list.add("gxffgj");
        list.add("dhftghf");

        Integer integer = (Integer) list.get(1);

    }

    public void methodThrowsNullPointerException() {
        String s = null;
        s.length();

    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass = new VeryComplexClass();

     //   veryComplexClass.methodThrowsClassCastException();
     //   veryComplexClass.methodThrowsNullPointerException();

    }
}
