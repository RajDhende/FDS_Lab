package Assignments.Assignment9.SeperateChainingImplementaion;

import java.util.*;

/**
 * An implementation of a hash map using separate chaining for collision resolution.
 *
 * @param <K> The type of keys.
 * @param <V> The type of values.
 */
class AbstractHashMap<K, V> {
    /**
     * Inner class representing an entry in the hash map.
     *
     * @param <K> The type of keys.
     * @param <V> The type of values.
     */
    protected class Entry<K, V> {
        K key;
        V value;

        /**
         * Constructs a new Entry with the specified key and value.
         *
         * @param key   The key of the entry.
         * @param value The value associated with the key.
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    protected List<Entry<K, V>>[] table;
    protected int capacity;
    private int size = 0;

    /**
     * Constructs a new hash map with the specified initial capacity.
     *
     * @param capacity The initial capacity of the hash map.
     */
    public AbstractHashMap(int capacity) {
        this.capacity = capacity;
        createTable();
    }

    /**
     * Creates the hash map table.
     */
    protected void createTable() {
        table = new LinkedList[capacity];
    }

    /**
     * Computes the hash value for a given key.
     *
     * @param key The key for which to compute the hash value.
     * @return The computed hash value.
     */
    protected int hashValue(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Retrieves the value associated with the specified key in the specified bucket.
     *
     * @param h The hash value of the key.
     * @param k The key for which to retrieve the value.
     * @return The value associated with the key, or null if not found.
     */
    public V bucketGet(int h, K k) {
        try {
            List<Entry<K, V>> bucket = table[h];
            if (bucket == null) return null;
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(k)) {
                    return entry.value;
                }
            }
            return null;
        } catch (NullPointerException e) {
            // Handle NullPointerException here
            System.err.println("NullPointerException: " + e.getMessage());
            return null;
        }
    }

    /**
     * Inserts or updates the key-value pair in the specified bucket.
     *
     * @param h The hash value of the key.
     * @param k The key to insert or update.
     * @param v The value to associate with the key.
     * @return The old value associated with the key, or null if the key is new.
     */
    public V bucketPut(int h, K k, V v) {
        try {
            List<Entry<K, V>> bucket = table[h];
            if (bucket == null) {
                bucket = new LinkedList<>();
                table[h] = bucket;
            }
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(k)) {
                    V old = entry.value;
                    entry.value = v;
                    return old;
                }
            }
            bucket.add(new Entry<>(k, v));
            size++;
            if (size > capacity / 2) {
                resize(2 * capacity - 1); // (2 * capacity - 1) is often prime
            }
            return null;
        } catch (NullPointerException e) {
            // Handle NullPointerException here
            System.err.println("NullPointerException: " + e.getMessage());
            return null;
        }
    }

    /**
     * Removes the key-value pair associated with the specified key in the specified bucket.
     *
     * @param h The hash value of the key.
     * @param k The key for which to remove the value.
     * @return The removed value associated with the key, or null if not found.
     */
    public V bucketRemove(int h, K k) {
        try {
            List<Entry<K, V>> bucket = table[h];
            if (bucket == null) return null;
            Iterator<Entry<K, V>> it = bucket.iterator();
            while (it.hasNext()) {
                Entry<K, V> entry = it.next();
                if (entry.key.equals(k)) {
                    V value = entry.value;
                    it.remove();
                    size--;
                    return value;
                }
            }
            return null;
        } catch (NullPointerException e) {
            // Handle NullPointerException here
            System.err.println("NullPointerException: " + e.getMessage());
            return null;
        }
    }

    /**
     * Returns a set view of the entries contained in this map.
     *
     * @return A set view of the entries contained in this map.
     */
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (List<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                set.addAll(bucket);
            }
        }
        return set;
    }

    /**
     * Resizes the hash map to the specified new capacity.
     *
     * @param newCap The new capacity of the hash map.
     */
    private void resize(int newCap) {
        List<Entry<K, V>>[] oldTable = table;
        table = new LinkedList[newCap];
        capacity = newCap;
        size = 0;
        for (List<Entry<K, V>> bucket : oldTable) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    bucketPut(hashValue(entry.key), entry.key, entry.value);
                }
            }
        }
    }
}

/**
 * A simple interface for interacting with the hash map.
 */
class HashMapInterface {
    /**
     * Main method to run the hash map interface.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the initial capacity of the HashMap:");
        int capacity = scanner.nextInt();
        AbstractHashMap<Integer, String> hashMap = new AbstractHashMap<>(capacity);

        while (true) {
            System.out.println("\n1. Put Key-Value Pair");
            System.out.println("2. Get Value by Key");
            System.out.println("3. Remove Key-Value Pair");
            System.out.println("4. Print All Entries");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");
            try {
                int choice = scanner.nextInt();

                int h, k;
                String v;
                switch (choice) {
                    case 1:
                        System.out.println("Enter the key and value to put:");
                        k = scanner.nextInt();
                        v = scanner.next();
                        h = hashMap.hashValue(k);
                        hashMap.bucketPut(h, k, v);
                        break;
                    case 2:
                        System.out.println("Enter the key to get the value:");
                        k = scanner.nextInt();
                        h = hashMap.hashValue(k);
                        System.out.println("The value is: " + hashMap.bucketGet(h, k));
                        break;
                    case 3:
                        System.out.println("Enter the key to remove the key-value pair:");
                        k = scanner.nextInt();
                        h = hashMap.hashValue(k);
                        System.out.println("The removed value is: " + hashMap.bucketRemove(h, k));
                        break;
                    case 4:
                        System.out.println("The entries in the HashMap are:");
                        for (AbstractHashMap.Entry entry : hashMap.entrySet()) {
                            System.out.println("Key: " + entry.key + ", Value: " + entry.value);
                        }
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Handle InputMismatchException here
                System.err.println("InputMismatchException: " + e.getMessage());
                scanner.next(); // Consume the invalid input
            }
        }
    }
}
