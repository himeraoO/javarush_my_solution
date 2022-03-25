package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date time = new Date();
        for (String s: strings) {
            ids.add(shortener.getId(s));
        }
        Date newTime = new Date();
        return newTime.getTime() - time.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date time = new Date();
        for (Long l: ids) {
            strings.add(shortener.getString(l));
        }
        Date newTime = new Date();
        return newTime.getTime() - time.getTime();
    }

    @Test
    public void testHashMapStorage(){
        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();

        Set<String> strings1 = new HashSet<>();
        Set<String> strings2 = new HashSet<>();

        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        long id1Time = getTimeToGetIds(shortener1, origStrings, ids1);
        long string1Time = getTimeToGetStrings(shortener1, ids1, strings1);

        long id2Time = getTimeToGetIds(shortener2, origStrings, ids2);
        long string2Time = getTimeToGetStrings(shortener2, ids2, strings2);


        Assert.assertTrue(id1Time > id2Time);

        Assert.assertEquals(string1Time, string2Time, 30);

    }

}
