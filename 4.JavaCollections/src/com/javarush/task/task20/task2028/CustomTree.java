package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    int count = 0;
    private ArrayList<Entry<String>> entries = new ArrayList<>();
    
    public CustomTree(){
        this.root = new Entry<String>(null);
        entries.add(root);
    }
   
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }
    
     @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
    
     @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }
    
     @Override
    public  String remove(int index) {
        throw new UnsupportedOperationException();
    }
    
     @Override
    public  List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    
     @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public  boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
    
//     public boolean add(String s) {
//        Entry<String> entry = new Entry<>(s);
//        int id = Integer.parseInt(s);
//        entry.id = id;
//        if(root == null){
//            root = entry;
//        } else {
//            Entry<String> current = root;
//            Entry<String> parent = null;
//            current.parent = parent;
//            while (true){
//                parent = current;
//                if(id < current.id){
//                    current = current.leftChild;
//                    if(current == null){
//                        parent.leftChild = entry;
//                        count++;
//                        return true;
//                    }
//                }else {
//                    current = current.rightChild;
//                    if(current == null){
//                        parent.rightChild = entry;
//                        count++;
//                        return true;
//                    }
//                }
//            }
//        }return false;
//    }

    public boolean add(String s) {
        Entry<String> entry = new Entry<>(s);
//        Entry<String> current = root;

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Entry<String> current = queue.poll();
            if (current.isAvailableToAddChildren()) {
                if (current.availableToAddLeftChildren) {
                    current.leftChild = entry;
                    entry.parent = current;
                    current.availableToAddLeftChildren = false;
                    count++;
                    return true;
                } else {
                    current.rightChild = entry;
                    entry.parent = current;
                    current.availableToAddRightChildren = false;
                    count++;
                    return true;
                }
            }else {
                if (current.leftChild != null){
                    queue.add(current.leftChild);
                }
                if (current.rightChild != null){
                    queue.add(current.rightChild);
                }
            }
        }


        /*
         Entry<String> entry = new Entry<>(s);
        Entry<String> current = root;
        Entry<String> parent;

        while (true) {
            parent = current;
            if (current.isAvailableToAddChildren()) {
                if (current.availableToAddLeftChildren) {
                    current = current.leftChild;
                    parent.leftChild = entry;
                    count++;
                    return true;
                } else {
                    current = current.rightChild;
                    parent.rightChild = entry;
                    count++;
                    return true;
                }
            } else {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = entry;
                    count++;
                    return true;
                } else if (parent.rightChild == null){
                    current = parent.rightChild;
                //    if (current == null) {
                        parent.rightChild = entry;
                        count++;
                        return true;
                   // }
                }
            }
        }
         */
//        return false;

        regen();
        return add(s);
    }

    public void regen(){
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> current = queue.poll();
            if(current.leftChild != null){
                queue.add(current.leftChild);
            }
            if(current.rightChild != null){
                queue.add(current.rightChild);
            }
            if((current.leftChild == null) && !current.availableToAddLeftChildren){
                current.availableToAddLeftChildren = true;
            }
            if((current.rightChild == null) && !current.availableToAddRightChildren){
                current.availableToAddRightChildren = true;
            }
        }
    }

        @Override
    public int size() {
        return count;
    }

    public String getParent(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> current = queue.poll();
            if (s.equals(current.elementName)){
                return current.parent.elementName;
            }
            if(current.leftChild != null){
                queue.add(current.leftChild);
            }
            if(current.rightChild != null){
                queue.add(current.rightChild);
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof String){
            Queue<Entry<String>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Entry<String> current = queue.poll();

                if (((String) o).equals(current.elementName)) {

                    int countDel = 0;
                    Queue<Entry<String>> queueDelete = new LinkedList<>();
                    queueDelete.add(current);
                    while (!queueDelete.isEmpty()) {
                        Entry<String> currentDel = queueDelete.poll();
                        countDel++;
                        if (currentDel.leftChild != null) {
                            queueDelete.add(currentDel.leftChild);
                        }
                        if (currentDel.rightChild != null) {
                            queueDelete.add(currentDel.rightChild);
                        }
                    }
//                    System.out.println(countDel);
                    count -= countDel;
                    Entry<String> parent = current.parent;
                    if(parent.leftChild != null){
                        if (parent.leftChild.elementName.equals(o)){
                            parent.leftChild = null;
                            return true;
                        }
                    }
                    if(parent.rightChild != null){
                        if (parent.rightChild.elementName.equals(o)){
                            parent.rightChild = null;
                            return true;
                        }
                    }

                }

                if (current.leftChild != null) {
                    queue.add(current.leftChild);
                }
                if (current.rightChild != null) {
                    queue.add(current.rightChild);
                }
            }
        }else {
            throw new UnsupportedOperationException();
        }
        return false;
    }

    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;
        
        public Entry(String s){
            this.elementName = s;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }
        
        public boolean isAvailableToAddChildren(){
            if(availableToAddRightChildren || availableToAddLeftChildren) return true;
            
            return false;
        }
        
        
    }
    
}
