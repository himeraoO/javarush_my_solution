package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        /*
        1) int size() - должен возвращать количество значений в нашей коллекции.
        */
        int size = 0;
        for (List<V> v: map.values()) {
            size += v.size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        /*
        2) V put(K key, V value) - должен добавить элемент value по ключу key.
        Если в мапе такой ключ уже есть, и количество значений по этому ключу меньше,
        чем repeatCount - то добавь элемент value в конец листа в объекте map.
        Если по такому ключу количество значений равняется repeatCount -
        то удали из листа в объекте map элемент с индексом ноль,
        и добавь в конец листа value.
        Метод должен возвращать значение последнего добавленного элемента по ключу key
        (но не значение, которое мы сейчас добавляем).
        Если по ключу key значений еще нет - верни null.
        */
        V val = null;

        if(map.containsKey(key)){
            List<V> list = map.get(key);
            if(repeatCount == list.size()) {
                val = list.get(list.size() - 1);
                list.remove(0);
                list.add(value);
            }
            if(repeatCount > list.size()) {
                val = list.get(list.size() - 1);
                list.add(value);
            }
        }else {
            List<V> list = new ArrayList<>();
            list.add(value);
            map.put(key,list);
        }
        return val;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        /*
        3) V remove(Object key) - должен удалить элемент по ключу key.
        Если по этому ключу хранится несколько элементов -
        должен удаляться элемент из листа с индексом ноль.
        Если по какому-то ключу хранится лист размером ноль элементов -
        удали такую пару ключ : значение. Метод должен возвращать элемент, который ты удалил.
        Если в мапе нет ключа key - верни null.
        */
        V val = null;

        List<V> list = map.get(key);

        if(map.containsKey(key)){
            if(list.size() > 0) {
                val = list.remove(0);
            }
            if(list.size() == 0) {
                map.remove(key);
            }
        }
        return val;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        /*
        4) Set<K> keySet() - должен вернуть сет всех ключей, которые есть в мапе map.
        */
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        /*
        5) Collection<V> values() - должен вернуть ArrayList<V> всех значений.
        Порядок значений в листе не имеет значения.
        */
        List<V> list = new ArrayList<>();
        for (List<V> v: map.values()) {
            list.addAll(v);
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        /*
        6) boolean containsKey(Object key) - должен вернуть true,
        если в мапе присутствует ключ key, иначе вернуть false.
        */
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        /*
        7) boolean containsValue(Object value) -
        должен вернуть true, если в мапе присутствует значение value, иначе вернуть false.
        */
//        for (List<V> v: map.values()) {
//            return v.contains(value);
//        }
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            for (V v : entry.getValue()) {
                if (v.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}