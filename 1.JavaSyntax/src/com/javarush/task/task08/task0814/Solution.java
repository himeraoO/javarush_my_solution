package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> integers = new HashSet<>();
        integers.add(11);
        integers.add(1);
        integers.add(5);
        integers.add(4);
        integers.add(117);
        integers.add(116);
        integers.add(151);
        integers.add(131);
        integers.add(1165);
        integers.add(9);
        integers.add(2);
        integers.add(3);
        integers.add(141);
        integers.add(1451);
        integers.add(156);
        integers.add(161);
        integers.add(191);
        integers.add(118);
        integers.add(1166);
        integers.add(8);
        return integers;

    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        set.removeIf(i -> i > 10);
        return set;

    }

    public static void main(String[] args) {

    }
}
