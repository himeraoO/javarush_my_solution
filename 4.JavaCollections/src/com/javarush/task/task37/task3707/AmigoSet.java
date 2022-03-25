package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();

    public AmigoSet() {
        map = new HashMap<>();
    }
    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16,(int)(collection.size()/.75f)+1);
        map = new HashMap<>(capacity);
//        for (E e: collection) {
//            map.put(e, PRESENT);
//        }
        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        if (!map.containsKey(e)) {
            map.put(e, PRESENT);
            return true;
        }
        return false;
    }

    private transient HashMap<E,Object> map;

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object clone(){
        try {
            AmigoSet<E> newSet = (AmigoSet<E>) super.clone();
            newSet.map = (HashMap<E, Object>) map.clone();
            return newSet;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return super.addAll(c);
    }

    private void writeObject(ObjectOutputStream outputStream){
        try {
            outputStream.defaultWriteObject();

            outputStream.writeObject(map.size());

            for(E e:map.keySet()){
                outputStream.writeObject(e);
            }
            outputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
            outputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream inputStream){
        try {
            inputStream.defaultReadObject();

            int size = (int)inputStream.readObject();

            Set<E> set = new HashSet<>();

            for(int i =0;i<size;i++){
                set.add((E)inputStream.readObject());
            }

            int capacity = (int)inputStream.readObject();

            float loadFactor = (float)inputStream.readObject();

            map = new HashMap<>(capacity,loadFactor);

            for(E e:set){
                map.put(e,PRESENT);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
