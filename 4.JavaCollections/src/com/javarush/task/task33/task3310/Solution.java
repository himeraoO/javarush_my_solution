package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        HashSet<Long> hashSet = new HashSet<>();
        for (String s: strings) {
            hashSet.add(shortener.getId(s));
        }
        return hashSet;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        HashSet<String> hashSet = new HashSet<>();
        for (Long l: keys) {
            hashSet.add(shortener.getString(l));
        }
        return hashSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        System.out.println(strategy.getClass().getSimpleName());
        HashSet<String> hashSet = new HashSet<>();
        for (long i = 1; i <= elementsNumber ; i++) {
            //strategy.put(i, Helper.generateRandomString());
            hashSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date time = new Date();
        HashSet<Long> longs = (HashSet<Long>) getIds(shortener, hashSet);
        Date newTime = new Date();
        long after = newTime.getTime() - time.getTime();
        Helper.printMessage(String.valueOf(after));

        Date time2 = new Date();
        HashSet<String> strings = (HashSet<String>) getStrings(shortener, longs);
        Date newTime2 = new Date();
        long after2 = newTime2.getTime() - time2.getTime();
        Helper.printMessage(String.valueOf(after2));

        if (strings.size() == hashSet.size()){
            strings.addAll(hashSet);
            if (strings.size() == hashSet.size()){
                Helper.printMessage("Тест пройден.");
            }
        }else {
            Helper.printMessage("Тест не пройден.");
        }




    }

    public static void main(String[] args) {
        int element = 150;
        testStrategy(new HashMapStorageStrategy(), element);
        System.out.println("////////////////////////////////////////////////////////////");
        testStrategy(new OurHashMapStorageStrategy(), element);
        System.out.println("////////////////////////////////////////////////////////////");
        testStrategy(new FileStorageStrategy(), element);
        System.out.println("////////////////////////////////////////////////////////////");
        testStrategy(new OurHashBiMapStorageStrategy(), element);
        System.out.println("////////////////////////////////////////////////////////////");
        testStrategy(new HashBiMapStorageStrategy(), element);
        System.out.println("////////////////////////////////////////////////////////////");
        testStrategy(new DualHashBidiMapStorageStrategy(), element);
    }
}
