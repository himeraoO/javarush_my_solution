package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
//        A a = null;
        try {
            Object a = objectStream.readObject();
            if(a instanceof A){
                return (A) a;
            }else {
                return null;
            }
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
