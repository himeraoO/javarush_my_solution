package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        try {
            System.out.println(isDateOdd("MAY 1 2013"));
//            System.out.println(isDateOdd("JANUARY 1 2000"));
//            System.out.println(isDateOdd("JANUARY 2 2020"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static boolean isDateOdd(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date date1 = formatter.parse(date);
        String[] sArr = date.split(" ");
        String s = sArr[2];
        String dateBegin = "JAN 1 " + s;
        Date date2 = formatter.parse(dateBegin);
        long day = 24 * 60 * 60 * 1000L;
        long difference = date1.getTime() - date2.getTime();
        int days = (int) (difference/day) + 1;
        if(days%2 == 0){
            return false;
        }
        return true;
    }
}
