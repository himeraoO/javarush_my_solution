package com.javarush.task.task40.task4009;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
        LocalDate localDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("d.M.y"));
        Year year1 = Year.parse(year, DateTimeFormatter.ofPattern("y"));
//        int day = localDate.getDayOfMonth();
//        int month = localDate.getMonthValue();
//        LocalDate newLocalDate = LocalDate.of(year1.getValue(), month, day);
//        DayOfWeek dayOfWeek = newLocalDate.getDayOfWeek();
 //       return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ITALIAN);
        return localDate.withYear(year1.getValue()).format(DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ITALIAN));

        /*
               DateTimeFormatter birthdayDateFormat = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate birthdayDate = LocalDate.parse(birthday, birthdayDateFormat);

        DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("y");
        Year yearDate = Year.parse(year, yearFormat);

        return birthdayDate.withYear(yearDate.getValue()).format(DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ITALIAN));
         */
    }
}
