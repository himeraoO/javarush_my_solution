package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy{

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    int hash(Long k){
        return (k == null) ? 0 : k.hashCode();
    }

    int indexFor(int hash, int length){
        return hash & (length - 1);
    }

    Entry getEntry(Long key){
        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
            if ((e.hash == hash) && (e.key.equals(key)) || (key != null && key.equals(e.key))) {
                return e;
            }
        }
        return null;
    }

    void resize(int newCapacity){
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    void transfer(Entry[] newTable){
//        for (Entry e: table) {
//            newTable[indexFor(hash(e.getKey()), newTable.length)] = e;
//        }
        int newCapacity = newTable.length;
        for (Entry e : table) {
            while (e != null) {
                Entry next = e.next;
                int indexInNewTable = indexFor(hash(e.getKey()), newCapacity);
                e.next = newTable[indexInNewTable];
                newTable[indexInNewTable] = e;
                e = next;
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        if (size++ >= threshold) {
            resize(2 * table.length);
        }
    }

    void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        Entry[] tab = table;
        for (int i = 0; i < tab.length ; i++)
            for (Entry e = tab[i] ; e != null ; e = e.next) {
                if (value.equals(e.value)) {
                    return true;
                }
                if (e.value == null){
                    return true;
                }
            }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        for (Entry e = table[i]; e != null; e = e.next) {
            if (key.equals(e.key)) {
                e.value = value;
                return;
            }
        }
        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        for (Entry eT : table)
            for (Entry e = eT; e != null; e = e.next)
                if (value.equals(e.value))
                    return e.getKey();
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

//    public static void main(String[] args) {
//        Long key = 2222222L;
//        Long h;
//        System.out.println(key.hashCode());
//        System.out.println(2222222 >>> 16);
//        System.out.println(1 << 30);
//        System.out.println((h = (long) key.hashCode()) ^ (h >>> 16));
//
//    }
}
