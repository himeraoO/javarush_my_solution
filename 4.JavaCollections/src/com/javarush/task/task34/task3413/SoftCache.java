package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {

        SoftReference<AnyObject> softReference = cacheMap.get(key);

        if(!cacheMap.containsKey(key)){
            return null;
        }

        return softReference.get();//напишите тут ваш код
    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        AnyObject object = null;
        if(softReference != null){
            object = softReference.get();
            softReference.clear();
        }
        return object;//напишите тут ваш код
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        AnyObject object = null;
        if(softReference != null){
            object = softReference.get();
            softReference.clear();
        }
        return object;//напишите тут ваш код
    }
}