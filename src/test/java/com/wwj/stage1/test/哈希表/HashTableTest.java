package com.wwj.stage1.test.哈希表;

import com.wwj.stage1.dataStructure.line.hashTable.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * auth sherry
 * data created in 2021/9/14 3:45 下午
 */
public class HashTableTest {

    @Test
    public void should_return_1_if_put_same_key_value() throws Exception {
        HashTable<String, Integer> hashTable = new HashTable<>();
        for (int i = 0; i < 10; i++) {
            hashTable.put("1",i);
        }
        assertEquals(1,hashTable.getSize());
    }

    @Test
    public void should_return_ok_if_put_ok() throws Exception {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("hi", "ok");
        assertEquals("ok", hashTable.get("hi"));
    }

    @Test
    public void should_return_32_if_first_resize() throws Exception {
        HashTable<Integer, Integer> hashTable = new HashTable<>();
        for (int i = 0; i < 13; i++) {
            hashTable.put(i, i);
        }
        assertEquals(32,hashTable.getCapacity());
    }

    @Test
    public void should_return_null_if_remove_a_key_value() throws Exception {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("a","a");
        assertEquals("a",hashTable.get("a"));

        hashTable.remove("a");
        assertNull(hashTable.get("a"));

    }
}
