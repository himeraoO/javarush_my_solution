package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Задача по алгоритмам Ӏ Java Syntax: 9 уровень, 11 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String line = reader.readLine();
        while (!line.isEmpty()) {
            list.add(line);
            line = reader.readLine();
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                for (int j = 0; j < array.length; j++) {
                    if (isNumber(array[j])) {
                        int a = Integer.parseInt(array[i]);
                        int b = Integer.parseInt(array[j]);
                        if (a > b) {
                            String s = array[i];
                            array[i] = array[j];
                            array[j] = s;
                        }
                    }
                }
            } else {
                for (int j = 0; j < array.length; j++) {
                    if (!isNumber(array[j])) {
                        if (!isGreaterThan(array[i], array[j])) {
                            String s = array[i];
                            array[i] = array[j];
                            array[j] = s;
                        }
                    }
                }
            }
        }
    }


//        List<String> s = new ArrayList<>();
//        List<Integer> c = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            if (isNumber(array[i])) {
//                c.add(Integer.parseInt(array[i]));
//            } else {
//                s.add(array[i]);
//            }
//        }
//        String[] sn = new String[s.size()];
//        Integer[] cn = new Integer[c.size()];
//        sn = s.toArray(new String[0]);
//        cn = c.toArray(new Integer[0]);
//
//        String temp = new String();
//        boolean isSorted1 = false;
//        while (!isSorted1) {
//            isSorted1 = true;
//            for (int i = 0; i < sn.length - 1; i++) {
//                if (isGreaterThan(sn[i], sn[i + 1])) {
//                    isSorted1 = false;
//                    temp = sn[i];
//                    sn[i] = sn[i + 1];
//                    sn[i + 1] = temp;
//                }
//            }
//        }
//
//        boolean isSorted2 = false;
//        int buf;
//
//        while (!isSorted2) {
//            isSorted2 = true;
//            for (int i = 0; i < cn.length - 1; i++) {
//                if (cn[i] > cn[i + 1]) {
//                    isSorted2 = false;
//
//                    buf = cn[i];
//                    cn[i] = cn[i+1];
//                    cn[i+1] = buf;
//                }
//            }
//
//
////            String temp = s.get(0);
////            int temp2 = c.get(0);
////        for(int i = 0; i < s.size(); i++){
////            for(int j = i; j < s.size(); j++){
////                if(isGreaterThan(temp,s.get(i))){
////                  temp = s.get(i);
////                }
////                if(temp2 < c.get(i)){
////                    temp2 = c.get(i);
////                }
////            }
////            sn.add(temp);
////            cn.add(temp2);
////        }
//            String[] newArray = new String[array.length];
//            int ns = 0;
//            int nc = 0;
//            for (int i = 0; i < array.length; i++) {
//                if (isNumber(array[i])) {
//                    newArray[i] = String.valueOf(cn[nc]);
//                    nc++;
//                } else {
//                    newArray[i] = sn[ns];
//                    ns++;
//                }
//            }
//            array = newArray;
//
//        }
//    }
//
//
////    Map<Integer, String> c = new HashMap<>();
////    Map<Integer, String> s = new HashMap<>();
////    for(int i = 0; i < array.length; i++){
////            if(isNumber(array[i]) == true){
////                c.put(i, array[i]);
////            }else{
////                s.put(i, array[i]);
////            }
////    }
////
////    String temp = new String();
////
////    for(int i = 0; i < s.size(); i++){
////        if(isGreaterThan(s.get(i), s.get(i+1)) == true){
////
////        }else{
////            temp = s.get(i);
////            s.get(i) = s.get(i+1);
////            s.get(i+1) = temp;
////        }
////    }
////
////         boolean isSorted = false;
////         int buf;
////
////        while(!isSorted) {
////            isSorted = true;
////            for (int i = 0; i < c.size()-1; i++) {
////                if(c.get(i) < c.get(i+1)){
////                    isSorted = false;
////
////                    buf = c.getValue(i);
////                    c.get(i) = c.get(i);
////                    c.get(i) = buf;
////                }
////            }
////        }


    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String text) {
        if (text.length() == 0) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];

            // есть '-' внутри строки
            if (i != 0 && character == '-') {
                return false;
            }

            // не цифра и не начинается с '-'
            if (!Character.isDigit(character) && character != '-') {
                return false;
            }

            // одиночный '-'
            if (chars.length == 1 && character == '-') {
                return false;
            }
        }

        return true;
    }
}
