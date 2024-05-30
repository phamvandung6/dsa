package thuchanh.tuan7.bai1;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
    private ArrEntry<K, E>[] arr;
    private int n = 0;
    private int defaultSize = 1000;

    @SuppressWarnings("unchecked")
    public UnsortedArrayPriorityQueue() {
        arr = (ArrEntry<K, E>[]) new ArrEntry[defaultSize];
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
    public void insert(Entry<K, E> entry) {
        if (n >= arr.length - 1) {
            resizeArray();
        }
        arr[n++] = new ArrEntry<>(entry.getKey(), entry.getValue());
    }

    @Override
    public void insert(K k, E e) {
        if (n == arr.length) {
            resizeArray();
        }
        arr[n++] = new ArrEntry<>(k, e);
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i].getKey().compareTo(arr[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }
        Entry<K, E> min = arr[minIndex];
        arr[minIndex] = arr[n - 1];
        arr[n - 1] = null;
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i].getKey().compareTo(arr[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }
        return arr[minIndex];
    }

    @SuppressWarnings("unchecked")
    private void resizeArray() {
        ArrEntry<K, E>[] newArr = (ArrEntry<K, E>[]) new ArrEntry[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, n);
        arr = newArr;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
