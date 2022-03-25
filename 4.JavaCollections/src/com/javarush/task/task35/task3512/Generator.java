package com.javarush.task.task35.task3512;

public class Generator<T> {
    
    public Generator(Class<T> clazz) {
        this.clazz = clazz;
    }

    Class<T> clazz;
    
    //необходимо исправить
    T newInstance() {
        T temp = null;
        try {
            temp = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return temp;
    }
}
