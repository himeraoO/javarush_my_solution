package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

//        ClassLoader - что это такое?
//        Реализуй логику метода getAllAnimals.
//        Аргумент метода pathToAnimals - это абсолютный путь к директории,
//        в которой хранятся скомпилированные классы.
//        Путь не обязательно содержит / в конце.
//        НЕ все классы наследуются от интерфейса Animal.
//        НЕ все классы имеют публичный конструктор без параметров.
//        Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров,
//        - создать по одному объекту.
//        Добавить созданные объекты в результирующий сет и вернуть.
//        Метод main не участвует в тестировании.
//
//
//        Requirements:
//        1. Размер множества возвращаемого методом getAllAnimals
//        должен быть равен количеству классов поддерживающих интерфейс Animal
//        и имеющих публичный конструктор без параметров
//        (среди классов расположенных в директории переданной в качестве параметра).
//        2. В множестве возвращаемом методом getAllAnimals должны присутствовать все классы
//        поддерживающие интерфейс Animal и имеющие публичный конструктор без параметров
//        (среди классов расположенных в директории переданной в качестве параметра).
//        3. В множестве возвращаемом методом getAllAnimals НЕ должен присутствовать
//        ни один класс не поддерживающий интерфейс Animal или не имеющий публичного конструктора без параметров
//        (среди классов расположенных в директории переданной в качестве параметра).
//        4. Метод getAllAnimals должен быть статическим.

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals =
                getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() +
                        Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        System.out.println(pathToAnimals);
//        String pathhh = "out/production/4.JavaCollections/com//javarush/task/task35/task3507/data";
        String pathhh = "out/production/4.JavaCollections/com/javarush/task/task35/task3507/data/";
//        MyClassloader myClassloader = new MyClassloader(pathToAnimals, ClassLoader.getSystemClassLoader());
//        MyClassloader myClassloader = new MyClassloader(pathhh, ClassLoader.getSystemClassLoader());
        MyClassloader myClassloader = new MyClassloader();
        HashSet<Animal> set = new HashSet<>();

        File dir = null;
        try {
            dir = new File(URLDecoder.decode(pathToAnimals, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //Path dir = Paths.get(URLDecoder.decode(pathToAnimals, "UTF-8"));
        System.out.println(dir.toString());
        File[] files = dir.listFiles();
        for (File f: files) {
//            String fileC = f.getPath().replaceAll("\\\\", ".");
//            System.out.println(fileC);
//            String p = "out.production.4.JavaCollections.com.javarush.task.task35.task3507.data.";
//            //String p = "com.javarush.task.task35.task3507.data.";
////           // System.out.println(f.getPath());
//            //System.out.println(f.getName());
//           // String name = Solution.class.getPackage().getName() + ".data." + f.getName().replaceAll(".class", "");
//            System.out.println(f.getAbsolutePath());
//            System.out.println(f.toPath().toString());
//            System.out.println(f.getCanonicalPath());
//            Class cl = Class.forName((p + f.getName()).replaceAll(".class",""), true, myClassloader);
//            Class cl = Class.forName(f.getName().replaceAll(".class",""), true, myClassloader);
//            Class cl = Class.forName(f.getName(), true, myClassloader);
            //Class cl = myClassloader.loadClass(name);
            Class cl = null;
            try {
                cl = myClassloader.loadClass(f.getAbsolutePath());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(cl.getSimpleName());
            if (Animal.class.isAssignableFrom(cl)) {
                Animal execute = null;
                try {
                    execute = (Animal) cl.newInstance();
                    set.add(execute);
                } catch (InstantiationException | IllegalAccessException e) {

                }
                //Animal execute = (Animal) cl.getConstructor(new Class[]{}).newInstance();

            }
            System.out.println("/////////////////////////////////////////////////////////////////");
        }

//        String[] objs = dir.list();
//        for (String s: objs) {
////            String str = dir.getPath() + "\\" + s;
//            String str = Solution.class.getPackage().getName() + ".data." + s;
//            System.out.println(str);
////            Class clazz = Class.forName(str, true, myClassloader);
//            Class clazz = myClassloader.loadClass(str);
//            //Animal execute = (Animal) clazz.newInstance();
//            System.out.println(clazz.getSimpleName());
//        }



//        String[] modules = dir.list();
//        for (String module : modules) {
//            System.out.println(module);
//            String moduleName = module.split(".class")[0];
//                Class clazz2 = myClassloader.loadClass("out.production.4.JavaCollections.com.javarush.task.task3507.data" + "." + moduleName);
//                Animal execute = (Animal) clazz2.newInstance();
//                set.add(execute);
//        }


//        try {
        ///////////////////////////////////////////////////
//        File dir2 = new File(pathToAnimals);
//        String[] modules = dir2.list();
//        for (String module : modules) {
//            System.out.println(module);
//            try {
//                String moduleName = module.split(".class")[0];
//                Class clazz2 = myClassloader.loadClass(moduleName);
//                Animal execute = (Animal) clazz2.newInstance();
//                set.add(execute);

                //////////////////////////////////////////////////
//            File dir = new File(URLDecoder.decode(pathToAnimals, "UTF-8"));
//            File [] files = dir.listFiles();
//            Class clazz;
//            for (int i = 0; i < files.length; i++) {
//                try {
//                    ////////////////////////////////////////
//                    String nameF = files[i].getName();
//                    if (nameF.endsWith(".class")) {
////                        clazz = myClassloader.loadClass(pathToAnimals + "/" +nameF);
////                        clazz = myClassloader.loadClass(Solution.class.getPackage().getName() + ".data." + nameF.replace(".class", ""));
//                        clazz = Class.forName(nameF.replace(".class", ""), true, myClassloader);
//                        if (Animal.class.isAssignableFrom(clazz)) {
//                            Animal animal = (Animal) clazz.getConstructor(new Class[]{}).newInstance();
//                            set.add(animal);
//                        }
//                    }
                ////////////////////////////////////////
////                    String nameF = files[i].getName();
//                    String nameF = Solution.class.getPackage().getName() + ".data." + files[i].getName().replace(".class", "");
//                  //  System.out.println(nameF);
////                    if (nameF.endsWith(".class")) {
////                        clazz = myClassloader.loadClass(pathToAnimals + "/" +nameF);
//                        clazz = myClassloader.loadClass(nameF);
//                        //Constructor[] constructor = clazz.getConstructors();
//                        if (Animal.class.isAssignableFrom(clazz)) {
//                            Animal animal = (Animal) clazz.getConstructor(new Class[]{}).newInstance();
//                            set.add(animal);
//                        }
//                    }
//                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
//                    //e.printStackTrace();
//                }
//            }


//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }


//            }
//        }

//                }

//            } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
//                e.printStackTrace();
//            }
//        }
        return set;
    }
}

class MyClassloader extends ClassLoader {
//    private String path;
//
//    public MyClassloader(String path, ClassLoader parent) {
//        super(parent);
//        this.path = path;
//    }

//    @Override
//    public Class<?> findClass(String className) throws ClassNotFoundException {
//        try {
//            byte b[] = fetchClassFromFS(path + className + ".class");
//            return defineClass(className, b, 0, b.length);
//        } catch (FileNotFoundException ex) {
//            return super.findClass(className);
//        } catch (IOException ex) {
//            return super.findClass(className);
//        }
//
//    }
//
//    private byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
//        InputStream is = new FileInputStream(new File(path));
//
//        long length = new File(path).length();
//
//        if (length > Integer.MAX_VALUE) {
//
//        }
//
//        byte[] bytes = new byte[(int)length];
//
//        int offset = 0;
//        int numRead = 0;
//        while (offset < bytes.length
//                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
//            offset += numRead;
//        }
//
//        if (offset < bytes.length) {
//            throw new IOException("Could not completely read file "+path);
//        }
//
//        is.close();
//        return bytes;
//
//    }


//    @Override
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//
//        byte[] buffer = new byte[0];
//        try {
//            buffer = Files.readAllBytes(Paths.get(name));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        return super.loadClass(name);
//        return defineClass(null, buffer, 0, buffer.length);
//    }

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
//@Override
//protected Class<?> findClass(String name) throws ClassNotFoundException {
//    // TODO Auto-generated method stub
//
//    String fileName = getFileName(name);
//
//    File file = new File(path,fileName);
//
//    try {
//        FileInputStream is = new FileInputStream(file);
//
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        int len = 0;
//        try {
//            while ((len = is.read()) != -1) {
//                bos.write(len);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        byte[] data = bos.toByteArray();
//        is.close();
//        bos.close();
//
//        return defineClass(name,data,0,data.length);
//
//    } catch (IOException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
//
//    return super.findClass(name);
//}
//
//    // Получить имя файла класса для загрузки
//    private String getFileName(String name) {
//        // TODO Auto-generated method stub
//        int index = name.lastIndexOf('.');
//        if(index == -1){
//            return name+".class";
//        }else{
//            return name.substring(index+1)+".class";
//        }
//    }

}