package thuchanh.tuan4.bai4;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    // Kích thước của mảng
    private int n = 0;
    // Index của phần tử đứng đầu
    private int top = 0;
    // Số lượng phần tử trong hàng đợi
    private int count = 0;
    private int default_size = 16;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    @Override
    public void enqueue(E element) {
        if (n == count) {
            resize();
        }
        queue[(top + count) % n] = element;
        count++;
    }

    @Override
    public E dequeue() {
        if (count == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int index = top;
        E element = queue[index];
        queue[index] = null;
        top = (top + 1) % n;
        count--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    private class ArrayQueueIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < n;
        }

        @Override
        public E next() {
            return queue[index++];
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = n * 2;
        E[] newQueue = (E[]) new Object[newCapacity];
        for (int i = 0; i < count; i++) {
            int index = (top + i) % n;
            newQueue[i] = queue[index];
        }
        queue = newQueue;
        n = newCapacity;
        top = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < count; i++) {
            sb.append(queue[(top + i) % n]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
