package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

public class Solution {
    public static void main(String[] args) {
        method1();
    }
/*

getStackTrace() 0
 method1()      1
 main           2


 getStackTrace() 0
 method2();      1
  method1()      2
 main            3

getStackTrace() 0
method3()       1
 method2();     2
  method1()     3
 main           4

 getStackTrace() 0
method4()       1
method3()       2
 method2();     3
  method1()     4
 main           5

 getStackTrace() 0
method5()       1
method4()       2
method3()       3
 method2();     4
  method1()     5
 main           6

 */
    public static String method1() {
        method2();
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElements[2].getMethodName());

        return stackTraceElements[2].getMethodName();

    }

    public static String method2() {
        method3();
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getMethodName());

        return stackTraceElements[2].getMethodName();

    }

    public static String method3() {
        method4();
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getMethodName());

        return stackTraceElements[2].getMethodName();

    }

    public static String method4() {
        method5();
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getMethodName());

        return stackTraceElements[2].getMethodName();

    }

    public static String method5() {
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getMethodName());

       return stackTraceElements[2].getMethodName();

    }
}
