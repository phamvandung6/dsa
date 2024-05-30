package thuchanh.tuan9.bai1;

public class Edge<T> {
    public Vertex<T> origin;
    public Vertex<T> destination;
    public double weight;

    public Edge(Vertex<T> origin, Vertex<T> destination, double weight) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    public Edge(Vertex<T> origin, Vertex<T> destination) {
        this.origin = origin;
        this.destination = destination;
        this.weight = 0.0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge<?> other = (Edge<?>) obj;
            return origin.equals(other.origin) && destination.equals(other.destination);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return origin.hashCode() * 31 + destination.hashCode();
    }
}
