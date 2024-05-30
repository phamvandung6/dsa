package data_structure_template.queue;

public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        this.data = data;
        right = null;
        left = null;
    }
}
