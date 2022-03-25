package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest prepareMyTest = (PrepareMyTest) c.getDeclaredAnnotation(PrepareMyTest.class);
            System.out.println(Arrays.toString(prepareMyTest.fullyQualifiedNames()));
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("[");
//            for (Class cl:prepareMyTest.value()) {
//                stringBuilder.append(cl.getSimpleName()).append(", ");
//            }
//            System.out.println(stringBuilder.substring(0,stringBuilder.length()-2) + "]");
            return true;
        }
        return false;
    }

//    public static boolean printFullyQualifiedNames(Class c) {
//    try {
//        PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
//        for (String fullyQualifiedName : prepareMyTest.fullyQualifiedNames()) {
//            System.out.println(fullyQualifiedName);
//        }
//    } catch (Exception e) {
//        return false;
//    }
//        return true;
//}

    public static boolean printValues(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest prepareMyTest = (PrepareMyTest) c.getDeclaredAnnotation(PrepareMyTest.class);
            System.out.println(Arrays.toString(prepareMyTest.value()));

            return true;
        }
        return false;
    }


//    public static boolean printValues(Class c) {
//        try {
//            PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
//            for (Class clazz : prepareMyTest.value()) {
//                System.out.println(clazz.getSimpleName());
//            }
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
}
