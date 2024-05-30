package on_tap_cuoi_ki.graph;

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
    public String toString() {
        return "Edge{" +
                "origin=" + origin +
                ", destination=" + destination +
                ", weight=" + weight +
                '}';
    }
}
