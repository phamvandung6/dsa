package thuchanh.tuan7.bai1;

import java.util.NoSuchElementException;

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        insert(entry.getKey(), entry.getValue());
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> newNode = new NodeEntry<>(k, e);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        NodeEntry<K, E> minNode = head;
        NodeEntry<K, E> prevNode = null;
        NodeEntry<K, E> current = head.next;
        NodeEntry<K, E> prevMin = null;

        while (current != null) {
            if (current.getKey().compareTo(minNode.getKey()) < 0) {
                minNode = current;
                prevMin = prevNode;
            }
            prevNode = current;
            current = current.next;
        }
        if (prevMin == null) {
            head = minNode.next;
        } else {
            prevMin.next = minNode.next;
        }
        if (minNode == tail) {
            tail = prevMin;
        }
        size--;
        return minNode;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        NodeEntry<K, E> minNode = head;
        NodeEntry<K, E> current = head.next;

        while (current != null) {
            if (current.getKey().compareTo(minNode.getKey()) < 0) {
                minNode = current;
            }
            current = current.next;
        }

        return minNode;
    }

    public void print() {
        NodeEntry<K, E> current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
