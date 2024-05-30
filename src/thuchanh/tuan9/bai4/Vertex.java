package thuchanh.tuan9.bai4;

public class Vertex<T> {
    public T element;
    public double distance;
    public Vertex<T> previous;

    public Vertex(T element) {
        this.element = element;
        this.distance = Double.POSITIVE_INFINITY;
        this.previous = null;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}