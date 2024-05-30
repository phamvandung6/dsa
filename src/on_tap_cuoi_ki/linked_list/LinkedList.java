package on_tap_cuoi_ki.linked_list;

import java.util.List;
import java.util.ArrayList;

public class LinkedList<T> {
    private List<T> list;

    public LinkedList() {
        list = new ArrayList<>();
    }

    public void insert(T data) {
        list.add(data);
    }

    public T get(int index) {
        return list.get(index);
    }

    public T remove(T data) {
        list.remove(data);
        return data;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
