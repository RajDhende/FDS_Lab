package Assignments.Assignment9.LinearProbingImplementation;

import java.util.*;

/**
 * A class representing a Linear Probing HashMap implementation.
 *
 * @param <K> The type of keys.
 * @param <V> The type of values.
 */
public class LinearProbingHashMap<K, V> {
    /**
     * A nested class representing an entry in the HashMap.
     *
     * @param <K> The type of keys.
     * @param <V> The type of values.
     */
    protected static class Entry<K, V> {
        K key;
        V value;

        /**
         * Constructs an Entry with the specified key and value.
         *
         * @param key   The key of the entry.
         * @param value The value associated with the key.
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    protected Entry<K, V>[] table;
    protected int capacity;
    private int size = 0;

    /**
     * Constructs a LinearProbingHashMap with the specified initial capacity.
     *
     * @param capacity The initial capacity of the HashMap.
     */
    public LinearProbingHashMap(int capacity) {
        this.capacity = capacity;
        createTable();
    }

    /**
     * Creates the table array.
     */
    protected void createTable() {
        table = new Entry[capacity];
    }

    /**
     * Computes the hash value for a given key.
     *
     * @param key The key for which the hash value is computed.
     * @return The computed hash value.
     */
    protected int hashValue(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Retrieves the value associated with the specified key in the HashMap.
     *
     * @param h The initial hash value.
     * @param k The key for which the value is retrieved.
     * @return The value associated with the key, or null if not found.
     */
    public V bucketGet(int h, K k) {
        for (int i = h; i < h + capacity; i++) {
            int j = i % capacity;
            if (table[j] == null) {
                return null;
            }
            if (table[j].key.equals(k)) {
                return table[j].value;
            }
        }
        return null;
    }

    /**
     * Inserts a key-value pair into the HashMap.
     *
     * @param h The initial hash value.
     * @param k The key to be inserted.
     * @param v The value associated with the key.
     * @throws IllegalStateException If an error occurs during the insertion process.
     */
    public void bucketPut(int h, K k, V v) {
        for (int i = h; i < h + capacity; i++) {
            int j = i % capacity;
            try {
                if (table[j] == null || table[j].key.equals(k)) {
                    V old = (table[j] == null) ? null : table[j].value;
                    table[j] = new Entry<>(k, v);
                    if (old == null) size++;
                    if (size > capacity / 2) {
                        resize(2 * capacity - 1); // (2 * capacity - 1) is often prime
                    }
                    return;
                }
            } catch (NullPointerException e) {
                throw new IllegalStateException("Error in bucketPut method", e);
            }
        }
        throw new IllegalStateException("Unable to insert the key-value pair.");
    }

    /**
     * Removes the key-value pair associated with the specified key from the HashMap.
     *
     * @param h The initial hash value.
     * @param k The key to be removed.
     * @return The value associated with the key, or null if not found.
     */
    public V bucketRemove(int h, K k) {
        for (int i = h; i < h + capacity; i++) {
            int j = i % capacity;
            if (table[j] == null) {
                return null;
            }
            if (table[j].key.equals(k)) {
                V value = table[j].value;
                table[j] = null;
                size--;
                return value;
            }
        }
        return null;
    }

    /**
     * Returns a set view of the entries contained in this HashMap.
     *
     * @return A set view of the entries contained in this HashMap.
     */
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                set.add(entry);
            }
        }
        return set;
    }

    /**
     * Resizes the HashMap to the specified new capacity.
     *
     * @param newCap The new capacity of the HashMap.
     */
    private void resize(int newCap) {
        Entry<K, V>[] oldTable = table;
        table = new Entry[newCap];
        capacity = newCap;
        size = 0;
        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                bucketPut(hashValue(entry.key), entry.key, entry.value);
            }
        }
    }
}

