package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
Работа с датами
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
        //напишите тут ваш код
        boolean printDate = true;
        boolean printTime = true;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        if (date.contains(".") && !date.contains(":")) {
            dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            printTime = false;
        }
        if (date.contains(":") && !date.contains(".")) {
            dateFormat = new SimpleDateFormat("HH:mm:ss");
            printDate = false;
        }

        if (printDate) {
            Date localDate = null;
            try {
                localDate = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
//            Calendar calendar = new GregorianCalendar();
            Calendar calendar = Calendar.getInstance();
            if (localDate != null) {
                calendar.setTime(localDate);
            }
//            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
//            System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK) - 1));
            System.out.println("День: " + calendar.get(Calendar.DATE));
            System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK)
                    == Calendar.SUNDAY ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
        }
        if (printTime) {
            Date localDate = null;
            try {
                localDate = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
//            Calendar calendar = new GregorianCalendar();
            Calendar calendar = Calendar.getInstance();
            if (localDate != null) {
                calendar.setTime(localDate);
            }
            System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        }
    }
}
