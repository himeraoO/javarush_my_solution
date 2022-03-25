package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    
    static{
        labels.put(2d, "ihglg");
        labels.put(1d, "ihghjgglg");
        labels.put(3d, "ihgljkug");
        labels.put(4d, "ihgw346tlg");
        labels.put(5d, "ihglfj67g");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
