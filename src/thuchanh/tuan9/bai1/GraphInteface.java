package thuchanh.tuan9.bai1;

import java.util.List;

public interface GraphInteface<T> {
    int numVertices();

    List<Vertex<T>> vertices();

    int numEdges();

    List<Edge<T>> edges();

    Edge<T> getEdge(Vertex<T> u, Vertex<T> v);

    Vertex<T>[] endVertices(Edge<T> e);

    Vertex<T> opposite(Vertex<T> v, Edge<T> e);

    int outDegree(Vertex<T> v);

    int inDegree(Vertex<T> v);

    List<Edge<T>> outgoingEdges(Vertex<T> v);

    List<Edge<T>> incomingEdges(Vertex<T> v);

    Vertex<T> insertVertex(T x);

    Edge<T> insertEdge(Vertex<T> u, Vertex<T> v);

    void removeVertex(Vertex<T> v);

    void removeEdge(Edge<T> e);
}
