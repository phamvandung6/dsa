package thuchanh.tuan6.bai2;

public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T value) {
        this.data = value;
        right = null;
        left = null;
    }
}