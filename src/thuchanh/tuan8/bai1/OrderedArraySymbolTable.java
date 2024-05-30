package thuchanh.tuan8.bai1;

import data_structure_template.array_list.SimpleArrayList;

public class OrderedArraySymbolTable<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value>
        implements OrderedSymbolTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int size;

    private static final int DEFAULT_CAPACITY = 100;

    @SuppressWarnings("unchecked")
    public OrderedArraySymbolTable(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public OrderedArraySymbolTable() {
        keys = (Key[]) new Comparable[DEFAULT_CAPACITY];
        values = (Value[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void put(Key key, Value value) {
        int index = rank(key);
        if (index < size && keys[index].compareTo(key) == 0) {
            values[index] = value;
        } else {
            for (int i = size; i > index; i--) {
                keys[i] = keys[i - 1];
                values[i] = values[i - 1];
            }
            keys[index] = key;
            values[index] = value;
            size++;
        }
    }

    @Override
    public Value get(Key key) {
        int index = rank(key);
        if (index < size && keys[index].compareTo(key) == 0) {
            return values[index];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        SimpleArrayList<Key> list = new SimpleArrayList<>();
        for (int i = 0; i < size; i++) {
            list.addFirst(keys[i]);
        }
        return list;
    }

    @Override
    public Key min() {
        if (isEmpty()) {
            return null;
        }
        return keys[0];
    }

    @Override
    public Key max() {
        if (isEmpty()) {
            return null;
        }
        return keys[size - 1];
    }

    @Override
    public Key floor(Key key) {
        int index = rank(key);
        if (index < size && index > 0) {
            return keys[index - 1];
        }
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        int index = rank(key);
        if (index < size - 1 && index >= 0) {
            return keys[index + 1];
        }
        return null;
    }

    @Override
    public int rank(Key key) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);

            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return low;
    }

    @Override
    public Key select(int k) {
        if (k < 0 || k >= size) {
            return null;
        }
        return keys[k];
    }

    @Override
    public void deleteMin() {
        if (isEmpty()) {
            return;
        }
        delete(min());
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) {
            return;
        }
        delete(max());
    }

    @Override
    public int size(Key u, Key v) {
        if (u.compareTo(v) > 0) {
            return 0;
        }
        int rankU = rank(u);
        int rankV = rank(v);
        if (rankU == -1 || rankV == -1) {
            return 0;
        }
        return rankV - rankU + 1;
    }

    @Override
    public Iterable<Key> keys(Key u, Key v) {
        SimpleArrayList<Key> list = new SimpleArrayList<>();
        int rankU = rank(u);
        int rankV = rank(v);
        for (int i = rankU; i <= rankV; i++) {
            list.addFirst(keys[i]);
        }
        return list;
    }

}