package on_tap_cuoi_ki.queue;

public interface QueueInterface<E> {
    public void enqueue(E data);

    public E dequeue();

    public E first();

    public int size();

    public boolean isEmpty();
}
