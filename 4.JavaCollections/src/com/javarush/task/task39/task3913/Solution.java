package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
//        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        LogParser logParser = new LogParser(Paths.get("D:/Всякие файлы/JAVA/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs"));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
//        System.out.println(logParser.execute("get ip"));
//        System.out.println(logParser.execute("get ip for user = \"Amigo\""));
//        System.out.println(logParser.execute("get user for date = \"03.01.2014 03:45:23\""));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
//        System.out.println(logParser.execute("get ip for event = \"WRITE_MESSAGE\" and date between \"11.12.2012 0:00:00\" and \"03.01.2014 23:59:59\""));
    }
}

/*
Парсер логов (8)
Ты реализовал парсер логов из разных файлов.

Помимо парсера, ты реализовал свой собственный язык запросов. Он нужен для того, что бы минимизировать количество методов. Строчка в нашем лог-файле содержала всего 5 параметров плюс один вариативный параметр.
При количестве параметров запроса два - это 25 возможный комбинаций, соответственно, что бы сделать любую выборку нужно реализовать 25 методов. Теперь представь, что параметров в строчке лог-файла не 5, а 10. И количество параметров запроса не 2, а 3. Уже нужно было бы написать 10 * 10 * 10 = 1000 методов.
Чем сложнее лог - тем больше времени разработчик может себе сэкономить.

Из рекомендаций и возможных улучшений можно реализовать запрос с количеством параметров 3, например такой:
get field1 for field2 = "value1" and field3 = "value2" and date between "after" and "before"

Из архитектурных улучшений в этой программе уместно использовать паттерн команда (для получения значения полей field, действуя единообразно). Реализуй его, если еще не сделал этого.


Requirements:
1. Поздравляю! Ты написал собственный парсер и свой язык запросов.
 */