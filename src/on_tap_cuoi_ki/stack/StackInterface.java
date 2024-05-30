package on_tap_cuoi_ki.stack;

public interface StackInterface<E> {
    public void push(E element);

    public E pop();

    public E top();

    public int size();

    public boolean isEmpty();
}