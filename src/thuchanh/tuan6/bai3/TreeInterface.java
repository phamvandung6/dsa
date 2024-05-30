package thuchanh.tuan6.bai3;

public interface TreeInterface<T extends Comparable<T>> {
    TreeInterface<T> insert(T data);

    void delete(T data);

    void traverse();

    T getMax();

    T getMin();

    boolean isEmpty();
}
