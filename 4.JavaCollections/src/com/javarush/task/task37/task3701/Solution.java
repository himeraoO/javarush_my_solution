package com.javarush.task.task37.task3701;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.*;

/* 
Круговой итератор
*/

public class Solution<T> extends ArrayList<T> {

    @Override
     public Iterator<T> iterator() {
        return new RoundIterator();
    }
    
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public class RoundIterator implements Iterator<T>{
        
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        RoundIterator() {}
      
        public boolean hasNext() {
            return size() > 0;
        }


        @SuppressWarnings("unchecked")

        public T next() {
            checkForComodification();
            int i = cursor;
            if (i >= Solution.this.size()) {
                i = 0;
            }
            Object[] elementData = null;
            try {
                Field elementDataField = ArrayList.class.getDeclaredField("elementData");
                elementDataField.setAccessible(true);
                elementData = (Object[]) elementDataField.get(Solution.this);

            } catch (NoSuchFieldException | IllegalAccessException e) {
            }
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (T) elementData[lastRet = i];
        }


        public void remove() {

            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                Solution.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;

            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }


        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();

        }
    }

}
