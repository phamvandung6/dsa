package thuchanh.tuan8.bai1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListSymbolTable<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> {
    private Node first;
    private int size;

    private class Node {
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public LinkedListSymbolTable() {
        first = null;
        size = 0;
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (value == null) {
            delete(key);
            return;
        }
        Node current = first;
        Node previous = null;
        while (current != null && key.compareTo(current.key) > 0) {
            previous = current;
            current = current.next;
        }
        if (current != null && key.compareTo(current.key) == 0) {
            current.value = value;
        } else {
            Node newNode = new Node(key, value, current);
            if (previous == null) {
                first = newNode;
            } else {
                previous.next = newNode;
            }
            size++;
        }
    }

    @Override
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        Node current = first;
        while (current != null && key.compareTo(current.key) > 0) {
            current = current.next;
        }
        if (current != null && key.compareTo(current.key) == 0) {
            return current.value;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        return () -> new KeyIterator();
    }

    private class KeyIterator implements Iterator<Key> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Key key = current.key;
            current = current.next;
            return key;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node current = first;
            sb.append("[");
            while (current != null) {
                sb.append(current.key).append(" ");
                current = current.next;
            }
            sb.append("]");
            return sb.toString();
        }

    }
}