package thuchanh.tuan8.bai1;

import java.util.ArrayList;
import java.util.List;

public class ArraySymbolTable<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int size;
    private static final int DEFAULT_CAPACITY = 100;

    @SuppressWarnings("unchecked")
    public ArraySymbolTable() {
        keys = (Key[]) new Comparable[DEFAULT_CAPACITY];
        values = (Value[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public ArraySymbolTable(int capacity) {
        // Khởi tạo mảng keys và values với kích thước ban đầu là capacity
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void put(Key key, Value value) {
        if (size == keys.length) {
            resize(keys.length * 2);
        }

        int index = indexOf(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    private int indexOf(Key key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        Key[] newKeys = (Key[]) new Comparable[newCapacity];
        Value[] newValues = (Value[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }

        keys = newKeys;
        values = newValues;
    }

    @Override
    public Value get(Key key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        return values[index];
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
        List<Key> keyList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            keyList.add(keys[i]);
        }
        return keyList;
    }
}
