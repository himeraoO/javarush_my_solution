package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy{
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    FileBucket[] table;
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize = 0;

    public FileStorageStrategy() {
        table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new FileBucket();
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    int hash(Long k){
        return (k == null) ? 0 : k.hashCode();
    }

    int indexFor(int hash, int length){
        return hash & (length - 1);
    }

    void resize(int newCapacity){
        FileBucket[] newTable = new FileBucket[newCapacity];
        for (int i = 0; i < newTable.length; i++) {
            newTable[i] = new FileBucket();
        }
        transfer(newTable);
        for (int i = 0; i < newTable.length; i++) {
            table[i].remove();
        }
        table = newTable;
    }

    void transfer(FileBucket[] newTable){
        int newCapacity = newTable.length;
        for (FileBucket fb : table) {
            if(fb.getFileSize() > 0){
                Entry e = fb.getEntry();
                while (e != null) {
                    Entry next = e.next;
                    int indexInNewTable = indexFor(hash(e.getKey()), newCapacity);
                    e.next = newTable[indexInNewTable].getEntry();
                    newTable[indexInNewTable].putEntry(e);;
                    e = next;
                }
            }
            long currentBucketSize = fb.getFileSize();
            if (currentBucketSize > maxBucketSize) {
                maxBucketSize = currentBucketSize;
            }
        }
    }

    Entry getEntry(Long key) {
        int hash = (key == null) ? 0 : hash(key);
        FileBucket fb = table[indexFor(hash, table.length)];
        if (fb.getFileSize() > 0) {
            for (Entry e = fb.getEntry(); e != null; e = e.next) {
                if ((e.hash == hash) && (e.key.equals(key)) || (key != null && key.equals(e.key))) {
                    return e;
                }
            }
        }
        return null;
    }

    void addEntry(int hash, Long key, String value, int bucketIndex){
        FileBucket fb = table[bucketIndex];
        Entry e = fb.getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        size++;
        if (maxBucketSize >= bucketSizeLimit) {
            resize(2 * table.length);
        }
    }

    void createEntry(int hash, Long key, String value, int bucketIndex){
        FileBucket fb = table[bucketIndex];
        Entry e = fb.getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (FileBucket fb : table) {
            if (fb.getFileSize() > 0) {
                for (Entry e = fb.getEntry(); e != null; e = e.next) {
                    if (value.equals(e.value)) {
                        return true;
                    }
                    if (e.value == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        FileBucket fb = table[i];
        for (Entry e = fb.getEntry(); e != null; e = e.next) {
            if (key.equals(e.key)) {
                e.value = value;
                return;
            }
        }
        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket fb : table) {
            if (fb.getFileSize() > 0) {
                for (Entry e = fb.getEntry(); e != null; e = e.next) {
                    if (value.equals(e.value)) {
                        return e.getKey();
                    }
                }
            }
        }
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
}
