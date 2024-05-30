package thuchanh.tuan6.bai3;

public class Node<T extends Comparable<T>> {
    public T data;
    public int height;
    public Node<T> left;
    public Node<T> right;

    public Node(T value) {
        this.data = value;
        height = 1;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
