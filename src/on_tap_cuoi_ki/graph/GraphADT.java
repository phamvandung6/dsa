package on_tap_cuoi_ki.graph;

import java.util.List;

public interface GraphADT<T> {
    public int numVertices();

    public List<Vertex<T>> vertices();

    public int numEdges();
    
    public List<Edge<T>> edges();

    public Edge<T> getEdge(Vertex<T> u, Vertex<T> v);

    public Vertex<T>[] endVertices(Edge<T> e);

    public Vertex<T> opposite(Vertex<T> v, Edge<T> e);

    public int outDegree(Vertex<T> v);

    public int inDegree(Vertex<T> v);

    public List<Edge<T>> outgoingEdges(Vertex<T> v);

    public List<Edge<T>> incomingEdges(Vertex<T> v);

    public Vertex<T> insertVertex(T element);

    public Edge<T> insertEdge(Vertex<T> u, Vertex<T> v, double weight);

    public void removeVertex(Vertex<T> v);

    public void removeEdge(Edge<T> e);
}
