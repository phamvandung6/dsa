package data_structure_template.single_linked_list;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
}