package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        MyClassloader myClassloader = new MyClassloader();
       // System.out.println(packageName);
        try {
            File dir = new File(URLDecoder.decode(packageName, "UTF-8"));
            File[] files = dir.listFiles();
            for (File f:files) {
               // System.out.println(f.getAbsolutePath());
                if(f.getAbsolutePath().endsWith(".class")){
//                    Class<?> clazz = Class.forName(f.getAbsolutePath().replaceAll("[.]class", ""));
                    Class<?> clazz = myClassloader.loadClass(f.getAbsolutePath());
                 //   System.out.println(clazz.getSimpleName());
                    hiddenClasses.add(clazz);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class h:hiddenClasses) {
            if((HiddenClass.class.isAssignableFrom(h)) && (h.getSimpleName().toLowerCase().startsWith(key.toLowerCase()))){
                Constructor<?> constructor = null;
                try {
                    constructor = h.getDeclaredConstructor();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                constructor.setAccessible(true);
                try {
                    HiddenClass hiddenClass = (HiddenClass) constructor.newInstance();
                    return hiddenClass;
                } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

class MyClassloader extends ClassLoader {
    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] buffer = new byte[0];
        try {
            buffer = Files.readAllBytes(Paths.get(className));
            return defineClass(null, buffer, 0, buffer.length);
        } catch (FileNotFoundException ex) {
            return super.findClass(className);
        } catch (IOException ex) {
            return super.findClass(className);
        }

    }
}

