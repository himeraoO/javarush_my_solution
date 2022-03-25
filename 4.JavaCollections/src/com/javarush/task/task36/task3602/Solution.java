package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args){
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws IndexOutOfBoundsException {
//        Class<?>[] classes = Collections.class.getDeclaredClasses();
//        for (Class<?> c: classes) {
//            if (List.class.isAssignableFrom(c) &&
//                    Modifier.isPrivate(c.getModifiers()) &&
//                    Modifier.isStatic(c.getModifiers())) {
////                System.out.println(c);
//
//                try {
//                    Method method = c.getDeclaredMethod("get", int.class);
////                    Constructor<?> constructor = c.getDeclaredConstructor();
////                    constructor.setAccessible(true);
//                    method.setAccessible(true);
////                    Object[] values = new Object[0];
////                    Object o = constructor.newInstance();
////                    method.invoke(o, 10);
//                    method.invoke(c.newInstance(), 10);
//                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
//                    if (e.getCause().toString().contains("IndexOutOfBoundsException")){
//                        return c;
//                    }
//                    //e.printStackTrace();
//                }
//
//            }
//        }
//
//
//
//
////        String path = "C:\\Users\\himer\\.jdks\\adopt-openjdk-14.0.2!\\java.base\\java\\util";
////        File file = new File(URLDecoder.decode(path, "UTF-8"));
////        System.out.println(file.getName());
////        System.out.println(file.getAbsolutePath());
////
////
////        String[] strings = file.list();
////        System.out.println(strings);
//////        for (String s:strings) {
//////            System.out.println(s);
//////        }
////        File[] files = file.listFiles();
////        System.out.println(files);
//////        for (File f:files) {
//////            System.out.println(f.getName());
//////        }
////        Class clazz = Collection.class;
////        List.class.isAssignableFrom(clazz);
        for (Class clazz : Collections.class.getDeclaredClasses()) {
            if (clazz.getSimpleName().equals("EmptyList")) {
                return clazz;
            }
        }
        return null;
    }
}
