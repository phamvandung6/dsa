package on_tap_cuoi_ki.tree;

public class Node<T extends Comparable<T>> {
    public T data;
    public Node<T> left;
    public Node<T> right;
    public Node<T> parent;

    public Node(T data) {
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }
}
