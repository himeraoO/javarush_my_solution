package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }

        // напишите тут ваш код
        Map<Character, Integer> map = new HashMap<>();
        for (String s: list) {
            for (Character c: s.toCharArray()) {
                if (map.containsKey(c)){
                    int i = map.get(c);
                    map.put(c, i + 1);
                }else {
                    map.put(c, 1);
                }
            }
        }

        for (Character c: alphabet) {
            int n = 0;
            if (map.containsKey(c)) {
                n = map.get(c);
            }
            if (n > 0){
                System.out.println(c + " " + n);
            }else {
                System.out.println(c + " " + 0);
            }
        }
    }
}
