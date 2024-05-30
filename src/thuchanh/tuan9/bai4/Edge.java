package thuchanh.tuan9.bai4;

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
}
