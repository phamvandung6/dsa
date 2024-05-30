package on_tap_cuoi_ki.queue;

public class Queue<E> implements QueueInterface<E> {
    private E[] queue;
    private int front;
    private int size;

    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        queue = (E[]) new Object[capacity];
        front = 0;
        size = 0;
    }

    @Override
    public void enqueue(E data) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        int rear = (front + size) % queue.length;
        queue[rear] = data;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E data = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return data;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}