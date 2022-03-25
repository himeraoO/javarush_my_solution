package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V extends Convertable<K>> Map<K,V> convert(List<V> list) {

        Map<K,V> result = new HashMap<>();
        for (V obj : list) {
            result.put(obj.getKey(), obj);
        }

        return result;
    }
}
