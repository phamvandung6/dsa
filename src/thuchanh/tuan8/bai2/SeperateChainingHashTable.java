package thuchanh.tuan8.bai2;

import java.util.LinkedList;

public class SeperateChainingHashTable<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;

    @SuppressWarnings("hiding")
    public class Entry<K, V> {
        public K key;
        public V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public SeperateChainingHashTable() {
        table = new LinkedList[INITIAL_CAPACITY];
    }

    public int hash(K key) {
        return key.hashCode() % table.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null)
            table[index] = new LinkedList<>();

        table[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] == null)
            return null;

        for (Entry<K, V> entry : table[index])
            if (entry.key.equals(key))
                return entry.value;

        return null;
    }
}
