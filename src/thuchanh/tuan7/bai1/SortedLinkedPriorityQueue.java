package thuchanh.tuan7.bai1;

import java.util.NoSuchElementException;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
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
        } else if (k.compareTo(head.getKey()) < 0) {
            newNode.next = head;
            head = newNode;
        } else {
            NodeEntry<K, E> current = head;
            NodeEntry<K, E> prev = null;

            while (current != null && k.compareTo(current.getKey()) > 0) {
                prev = current;
                current = current.next;
            }

            if (current == null) {
                tail.next = newNode;
                tail = newNode;
            } else {
                prev.next = newNode;
                newNode.next = current;
            }
        }
        size++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        Entry<K, E> minEntry = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head;
    }

    public void print() {
        NodeEntry<K, E> current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
