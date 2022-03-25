package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
     private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        String s = currencyCode.toUpperCase();
        if(map.containsKey(s)){
            return map.get(s);
        }else {
            CurrencyManipulator currencyManipulator = new CurrencyManipulator(s);
            map.put(s, currencyManipulator);
            return currencyManipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return map.values();
    }

}
