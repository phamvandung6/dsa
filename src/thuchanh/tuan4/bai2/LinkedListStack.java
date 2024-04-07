package thuchanh.tuan4.bai2;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
    }

    private Node stack = null;

    @Override
    public Iterator<E> iterator() {
        return new LinkedListStackIterator();
    }

    @Override
    public void push(E element) {
        Node newNode = new Node();
        newNode.element = element;
        newNode.next = stack;
        stack = newNode;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E element = stack.element;
        stack = stack.next;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.element;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.element;
    }

    private class LinkedListStackIterator implements Iterator<E> {
        private Node current = stack;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                System.out.println("Exception");
            }
            E element = current.element;
            current = current.next;
            return element;
        }

    }
}
