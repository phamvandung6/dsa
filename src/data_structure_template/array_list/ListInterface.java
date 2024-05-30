package data_structure_template.array_list;

public interface ListInterface<T> extends Iterable<T> {
    public void addFirst(T data);

    public T get(int i);

    public void set(int i, T data);

    public void remove(T data);

    public boolean isContain(T data);

    public int size();

    public boolean isEmpty();
}