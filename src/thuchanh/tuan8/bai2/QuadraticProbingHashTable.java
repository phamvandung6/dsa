package thuchanh.tuan8.bai2;

public class QuadraticProbingHashTable<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] table;
    private int size;

    public static class Entry<K, V> {
        public K key;
        public V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public QuadraticProbingHashTable() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    public int hash(K key) {
        return key.hashCode() % table.length;
    }

    public void put(K key, V value) {
        if (size >= table.length) {
            resize();
        }
        int index = hash(key);
        int i = 1;
        while (table[index] != null && (table[index].key != null)) {
            index = (index + i * i) % table.length;
            i++;
        }
        table[index] = new Entry<>(key, value);
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        int i = 1;
        while (table[index] != null) {
            if (table[index].key != null && table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + i * i) % table.length;
            i++;
        }
        return null;
    }

    private void resize() {
        @SuppressWarnings("unchecked")
        Entry<K, V>[] newTable = new Entry[2 * table.length];
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                put((K) entry.key, (V) entry.value, newTable);
            }
        }
        table = newTable;
    }

    private void put(K key, V value, Entry<K, V>[] table) {
        int index = hash(key);
        int i = 1;
        while (table[index] != null && (table[index].key != null)) {
            index = (index + i * i) % table.length;
            i++;
        }
        table[index] = new Entry<>(key, value);
    }
}
