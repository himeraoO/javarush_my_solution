package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        boolean printDate = true;
        boolean printTime = true;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d.M.y H:m:s");
        if (date.contains(".") && !date.contains(":")) {
            dateFormat = DateTimeFormatter.ofPattern("d.M.y");
            printTime = false;
        }
        if (date.contains(":") && !date.contains(".")) {
            dateFormat = DateTimeFormatter.ofPattern("H:m:s");
            printDate = false;
        }

        if (printDate) {
            LocalDate localDate = LocalDate.parse(date, dateFormat);
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + localDate.format(DateTimeFormatter.ofPattern("W")));
            System.out.println("Неделя года: " + localDate.format(DateTimeFormatter.ofPattern("w")));
            System.out.println("Месяц: " + localDate.getMonth().getValue());
            System.out.println("Год: " + localDate.getYear());
        }
        if (printTime) {
            LocalTime localTime = LocalTime.parse(date, dateFormat);
            System.out.println("AM или PM: " + localTime.format(DateTimeFormatter.ofPattern("a")));
            System.out.println("Часы: " + localTime.format(DateTimeFormatter.ofPattern("K")));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());
        }
//        DateTimeFormatter formatter = null;
//
//        if(date.contains(" ")){
//            formatter = DateTimeFormatter.ofPattern("d.M.y H:m:s");
//            LocalDate localDate = LocalDate.parse(date, formatter);
////            ChronoField chronoField = localDate.get;
//            System.out.println("День: " + localDate.getDayOfMonth());
////            System.out.println("День: " + localDate.get(ChronoField.));
//            System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
//            System.out.println("День месяца: " + localDate.getDayOfMonth());
//            System.out.println("День года: " + localDate.getDayOfYear());
//            System.out.println("Неделя месяца: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
//            System.out.println("Неделя года: " + localDate.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
//            System.out.println("Месяц: " + localDate.getMonth().getValue());
//            System.out.println("Год: " + localDate.getYear());
//            //System.out.println("AM или PM: " + localDate.get(ChronoField.AMPM_OF_DAY));
//            //System.out.println("Часы: " + localDate.get(ChronoField.HOUR_OF_AMPM));
//            System.out.println("Часы дня: " + localDate.get(ChronoField.HOUR_OF_DAY));
//            System.out.println("Минуты: " + localDate.get(ChronoField.MINUTE_OF_HOUR));
//            System.out.println("Секунды: " + localDate.get(ChronoField.SECOND_OF_MINUTE));
//
//        }
//        if(!date.contains(" ") && date.contains(".")){
//            formatter = DateTimeFormatter.ofPattern("d.M.y");
//        }
//        if(!date.contains(" ") && date.contains(":")){
//            formatter = DateTimeFormatter.ofPattern("h:m:s");
//        }
////        if(formatter != null) {
////            LocalDate localDate = LocalDate.parse(date, formatter);
////        }
//
//        //напишите тут ваш код
    }
}
