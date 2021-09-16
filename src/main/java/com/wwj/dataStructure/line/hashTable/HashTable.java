package com.wwj.dataStructure.line.hashTable;

import java.math.BigDecimal;

/**
 * auth sherry
 * data created in 2021/9/14 3:05 下午
 */
public class HashTable<K, V> {
    private int capacity = 16;

    private static final int LINK_MAX_LENGTH = 8;

    private float load_factor = 0.75f;

    private int size = 0;

    private Entry<K, V>[] entries;

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    static class Entry<K, V> {
        private final K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        this.entries = new Entry[capacity];
    }

    public V get(K key) {
        int keyIndex = hash(key);

        if (entries[keyIndex] == null) {
            return null;
        }
        return entries[keyIndex].value;
    }

    public void remove(K key) {
        int keyIndex = hash(key);

        Entry<K, V> entry = entries[keyIndex];
        if (entry == null) {
            return;
        }

        Entry<K, V> p = entry;
        Entry<K, V> pre = null;
        do {
            if (p.key == key) {
                if (pre == null) {
                    entries[keyIndex] = p.next;
                } else {
                    pre.next = p.next;
                }
            }
            pre = p;
            p = p.next;
        } while (p != null && p.next != null);

        // TODO: 2021/9/15 考虑缩容
    }

    public void put(K key, V val) {
        if (shouldResize()) {
            this.capacity = capacity * 2;
            Entry<K, V>[] newEntries = new Entry[capacity];
            for (Entry<K, V> entry : entries) {
                if (entry != null) {
                    Entry<K, V> p = entry;
                    do {
                        putKeyValue(p.key, p.value, newEntries);
                        if (p.next != null) {
                            p = p.next;
                        }
                    } while (p.next != null);
                }
            }
            entries = newEntries;
        }
        if (putKeyValue(key, val, entries)) {
            size++;
        }
    }

    /**
     * @param key        键
     * @param val        值
     * @param entryArray entry数组
     * @return 如果key已经存在，则返回false，否则返回true
     */
    private boolean putKeyValue(K key, V val, Entry<K, V>[] entryArray) {
        int keyIndex = hash(key);
        int linkSize = 0;
        Entry<K, V> newEntry = new Entry<K, V>(key, val);
        if (entryArray[keyIndex] == null) {
            entryArray[keyIndex] = newEntry;
        } else {
            Entry<K, V> entry = entryArray[keyIndex];
            do {
                linkSize++;
                if (entry.key == key) {
                    entry.value = val;
                    return false;
                }
                entry = entry.next;
            } while (entry.next != null);
            entry.next = newEntry;
            if (linkSize > LINK_MAX_LENGTH) {
                // TODO: 2021/9/15 链表转红黑树或跳表
            }
        }
        return true;
    }

    private int hash(Object key) {
        int h = key.hashCode();
        return (h ^ (h >>> 16)) & (capacity - 1); //capacity表示散列表的大小
    }

    private boolean shouldResize() {
        return BigDecimal.valueOf(size + 1).divide(BigDecimal.valueOf(capacity)).floatValue()
            > load_factor;
    }


}
