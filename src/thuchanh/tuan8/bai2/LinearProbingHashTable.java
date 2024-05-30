package thuchanh.tuan8.bai2;

public class LinearProbingHashTable<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] table;
    private int size;

    public static class Entry<K, V> {
        public K key;
        public V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    LinearProbingHashTable() {
        table = new Entry[INITIAL_CAPACITY];
    }

    public int hash(K key) {
        return key.hashCode() % table.length;
    }

    public void put(K key, V value) {
        if (size == table.length) {
            resize();
        }
        int index = hash(key);
        while (table[index] != null) {
            index = (index + 1) % table.length;
        }
        table[index] = new Entry<>(key, value);
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % table.length;
        }
        return null;
    }

    private void resize() {
        @SuppressWarnings("unchecked")
        Entry<K, V>[] newTable = new Entry[2 * table.length];
        for (Entry<K, V> entry : table)
            if (entry != null)
                put((K) entry.key, (V) entry.value, newTable);
        table = newTable;
    }

    void put(K key, V value, Entry<K, V>[] table) {
        int index = hash(key);
        for (int i = 0; i < table.length; i++) {
            int j = (index + i) % table.length;
            if (table[j] == null) {
                table[j] = new Entry<>(key, value);
                return;
            }
        }
    }
}