package thuchanh.tuan9.bai1;

import java.util.*;

public class UndirectedGraph<T> implements GraphInteface<T> {
    private Map<Vertex<T>, List<Edge<T>>> adjacencyList;
    private int edgeCount;

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
        edgeCount = 0;
    }

    @Override
    public int numVertices() {
        return adjacencyList.size();
    }

    @Override
    public List<Vertex<T>> vertices() {
        List<Vertex<T>> vertices = new ArrayList<>();
        for (Vertex<T> vertex : adjacencyList.keySet()) {
            vertices.add(vertex);
        }
        return vertices;
    }

    @Override
    public int numEdges() {
        return edgeCount;
    }

    @Override
    public List<Edge<T>> edges() {
        List<Edge<T>> edges = new ArrayList<>();
        for (List<Edge<T>> edgeList : adjacencyList.values()) {
            edges.addAll(edgeList);
        }
        return edges;
    }

    @Override
    public Edge<T> getEdge(Vertex<T> u, Vertex<T> v) {
        for (Edge<T> edge : adjacencyList.get(u)) {
            if (edge.destination.equals(v)) {
                return edge;
            }
        }
        return null;
    }

    @Override
    public Vertex<T>[] endVertices(Edge<T> e) {
        @SuppressWarnings("unchecked")
        Vertex<T>[] endVertices = new Vertex[2];
        endVertices[0] = e.origin;
        endVertices[1] = e.destination;
        return endVertices;
    }

    @Override
    public Vertex<T> opposite(Vertex<T> v, Edge<T> e) {
        Vertex<T> origin = e.origin;
        Vertex<T> destination = e.destination;
        if (v.equals(origin)) {
            return destination;
        } else if (v.equals(destination)) {
            return origin;
        }
        throw new IllegalArgumentException("Edge " + e + " does not incident to vertex " + v);
    }

    @Override
    public int outDegree(Vertex<T> v) {
        return adjacencyList.get(v).size();
    }

    @Override
    public int inDegree(Vertex<T> v) {
        return outDegree(v);
    }

    @Override
    public List<Edge<T>> outgoingEdges(Vertex<T> v) {
        return adjacencyList.get(v);
    }

    @Override
    public List<Edge<T>> incomingEdges(Vertex<T> v) {
        return adjacencyList.get(v);
    }

    @Override
    public Vertex<T> insertVertex(T x) {
        Vertex<T> vertex = new Vertex<>(x);
        adjacencyList.put(vertex, new ArrayList<>());
        return vertex;
    }

    @Override
    public Edge<T> insertEdge(Vertex<T> u, Vertex<T> v) {
        if (!adjacencyList.containsKey(u) || !adjacencyList.containsKey(v)) {
            return null;
        }
        Edge<T> edge = new Edge<>(u, v);
        adjacencyList.get(u).add(edge);
        adjacencyList.get(v).add(edge);
        edgeCount++;
        return edge;
    }

    public Edge<T> insertEdge(Edge<T> e) {
        if (!adjacencyList.containsKey(e.origin) || !adjacencyList.containsKey(e.destination)) {
            return null;
        }
        adjacencyList.get(e.origin).add(e);
        adjacencyList.get(e.destination).add(e);
        edgeCount++;
        return e;
    }

    @Override
    public void removeVertex(Vertex<T> v) {
        if (!adjacencyList.containsKey(v)) {
            return;
        }
        for (Edge<T> edge : adjacencyList.get(v)) {
            adjacencyList.get(edge.origin).remove(edge);
            adjacencyList.get(edge.destination).remove(edge);
        }
        adjacencyList.remove(v);
    }

    @Override
    public void removeEdge(Edge<T> e) {
        Vertex<T> u = e.origin;
        Vertex<T> v = e.destination;
        if (!adjacencyList.containsKey(u) || !adjacencyList.containsKey(v)) {
            return;
        }
        adjacencyList.get(u).remove(e);
        adjacencyList.get(v).remove(e);
        edgeCount--;
    }

}