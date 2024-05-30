package thuchanh.tuan7.bai1;

import java.util.NoSuchElementException;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
    protected ArrEntry<K, E>[] arr;
    protected int size;
    private int defaultSize = 1000;

    @SuppressWarnings("unchecked")
    public SortedArrayPriorityQueue() {
        arr = new ArrEntry[defaultSize];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (size == arr.length) {
            resizeArray();
        }
        insert(entry.getKey(), entry.getValue());
    }

    @Override
    public void insert(K k, E e) {
        if (size == arr.length) {
            resizeArray();
        }
        int i = size - 1;
        while (i >= 0 && k.compareTo(arr[i].getKey()) < 0) {
            arr[i + 1] = arr[i];
            i--;
        }

        arr[i + 1] = new ArrEntry<>(k, e);
        size++;
    }

    @Override
    public ArrEntry<K, E> removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }

        ArrEntry<K, E> min = arr[0];
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size--] = null;

        return min;
    }

    @Override
    public ArrEntry<K, E> min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        return arr[0];
    }

    @SuppressWarnings("unchecked")
    private void resizeArray() {
        ArrEntry<K, E>[] newHeap = new ArrEntry[arr.length * 2];
        System.arraycopy(arr, 0, newHeap, 0, size);
        arr = newHeap;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

    public ArrEntry<K, E>[] getArr() {
        return arr;
    }
}