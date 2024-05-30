package data_structure_template.stack;

import java.util.NoSuchElementException;

public class StackLinkedList<T> {
    private Node<T> top;

    public StackLinkedList() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T value = top.data;
        top = top.next;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.data;
    }

    public int size() {
        int size = 0;
        Node<T> temp = top;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}
