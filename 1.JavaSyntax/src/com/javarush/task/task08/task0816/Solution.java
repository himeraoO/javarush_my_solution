package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Смирнов", dateFormat.parse("JUNE 1 2012"));
        map.put("Смирнов1", dateFormat.parse("MAY 1 2012"));
        map.put("Смирнов2", dateFormat.parse("JULY 1 2012"));
        map.put("Смирнов3", dateFormat.parse("APRIL 1 2012"));
        map.put("Смирнов4", dateFormat.parse("MARCH 1 2012"));
        map.put("Смирнов5", dateFormat.parse("MAY 1 2012"));
        map.put("Смирнов6", dateFormat.parse("MAY 1 2012"));
        map.put("Смирнов7", dateFormat.parse("JULY 1 2012"));
        map.put("Смирнов8", dateFormat.parse("JUNE 1 2012"));
        map.put("Смирнов9", dateFormat.parse("MAY 1 2012"));
return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        map.values().removeIf(d -> d.getMonth() > 4 && d.getMonth() < 8);

        //напишите тут ваш код
//        for (Map.Entry<String , Date> d: map.entrySet()) {
//
//            if (d.getValue().getMonth() > 4 && d.getValue().getMonth() <8)
//                map.remove(d.getKey());
//        }


    }

    public static void main(String[] args) {

    }
}
