package thuchanh.tuan5.bai1;

public class Node<T> {
    public T value;
    public Node<T> left;
    public Node<T> right;

    Node(T value) {
        this.value = value;
        right = null;
        left = null;
    }
}