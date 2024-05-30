package on_tap_cuoi_ki.graph;

public class Vertex<T> {
    public T data;

    public Vertex(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
