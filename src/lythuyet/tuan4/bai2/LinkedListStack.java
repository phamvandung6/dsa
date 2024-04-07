package lythuyet.tuan4.bai2;

public class LinkedListStack<E> implements Stack<E> {
    private class Node {
        E element;
        Node next;
    }

    private Node stack = null;

    public void push(E element) {
        Node newNode = new Node();
        newNode.element = element;
        newNode.next = stack;
        stack = newNode;
    }
    

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        E element = stack.element;
        stack = stack.next;
        return element;
    }

    public boolean isEmpty() {
        return stack == null;
    }
}
