package data_structure_template.array_list;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] arrays;

    private int n = 0;

    private int defaultSize = 100;

    public SimpleArrayList() {
        arrays = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int size) {
        arrays = (T[]) new Object[size];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < n;
            }

            @Override
            public T next() {
                return arrays[index++];
            }
        };
    }

    @Override
    public void addFirst(T data) {
        if (n == arrays.length) {
            ensureCapacity();
        }
        for (int i = n; i > 0; i--) {
            arrays[i] = arrays[i - 1];
        }
        arrays[0] = data;
        n++;
    }

    public void add(T data) {
        if (n == arrays.length) {
            ensureCapacity();
        }
        arrays[n] = data;
        n++;
    }

    @Override
    public T get(int i) {
        return arrays[i];
    }

    @Override
    public void set(int i, T data) {
        arrays[i] = data;
    }

    @Override
    public void remove(T data) {
        for (int i = 0; i < n; i++) {
            if (arrays[i].equals(data)) {
                for (int j = i; j < n - 1; j++) {
                    arrays[j] = arrays[j + 1];
                }
                arrays[n - 1] = null;
                n--;
                return;
            }
        }
    }

    @Override
    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (arrays[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < n - 1; i++) {
            sb.append(arrays[i]).append(", ");
        }
        sb.append(arrays[n - 1]).append("]");
        return sb.toString();
    }

    public boolean search(T data) {
        for (int i = 0; i < n; i++) {
            if (arrays[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    private void ensureCapacity() {
        if (n == arrays.length) {
            int newCapacity = arrays.length * 2;
            T[] newArray = (T[]) new Object[newCapacity];
            System.arraycopy(arrays, 0, newArray, 0, n);
            arrays = newArray;
        }
    }

    public int indexOf(T data) {
        for (int i = 0; i < n; i++) {
            if (arrays[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }
}
