package on_tap_cuoi_ki.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedGraph<T> implements GraphADT<T> {
    private Map<Vertex<T>, List<Edge<T>>> adjList;

    public UndirectedGraph() {
        adjList = new HashMap<>();
    }

    @Override
    public int numVertices() {
        return adjList.size();
    }

    @Override
    public List<Vertex<T>> vertices() {
        return List.copyOf(adjList.keySet());
    }

    @Override
    public int numEdges() {
        int edgeCount = 0;
        for (List<Edge<T>> edges : adjList.values()) {
            edgeCount += edges.size();
        }
        return edgeCount / 2;
    }

    @Override
    public List<Edge<T>> edges() {
        List<Edge<T>> edges = new ArrayList<>();
        for (List<Edge<T>> edgeList : adjList.values()) {
            edges.addAll(edgeList);
        }
        return edges;
    }

    @Override
    public Edge<T> getEdge(Vertex<T> u, Vertex<T> v) {
        for (Edge<T> edge : adjList.get(u)) {
            if (edge.destination.equals(v)) {
                return edge;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Vertex<T>[] endVertices(Edge<T> e) {
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
        return adjList.get(v).size();
    }

    @Override
    public int inDegree(Vertex<T> v) {
        return outDegree(v);
    }

    @Override
    public List<Edge<T>> outgoingEdges(Vertex<T> v) {
        return adjList.get(v);
    }

    @Override
    public List<Edge<T>> incomingEdges(Vertex<T> v) {
        return adjList.get(v);
    }

    @Override
    public Vertex<T> insertVertex(T element) {
        if (adjList.containsKey(element)) {
            throw new IllegalArgumentException("Vertex " + element + " already exists");
        }
        Vertex<T> v = new Vertex<>(element);
        adjList.put(v, new ArrayList<>());
        return v;
    }

    @Override
    public Edge<T> insertEdge(Vertex<T> u, Vertex<T> v, double weight) {
        if (!adjList.containsKey(u) || !adjList.containsKey(v)) {
            throw new IllegalArgumentException("Vertex " + u + " or " + v + " does not exist");
        }
        Edge<T> e = new Edge<>(u, v, weight);
        adjList.get(u).add(e);
        adjList.get(v).add(e);
        return e;
    }

    @Override
    public void removeVertex(Vertex<T> v) {
        if (!adjList.containsKey(v)) {
            throw new IllegalArgumentException("Vertex " + v + " does not exist");
        }
        for (Edge<T> e : adjList.get(v)) {
            adjList.get(e.origin).remove(e);
            adjList.get(e.destination).remove(e);
        }
        adjList.remove(v);
    }

    @Override
    public void removeEdge(Edge<T> e) {
        if (!adjList.containsKey(e.origin) || !adjList.containsKey(e.destination)) {
            throw new IllegalArgumentException("Vertex " + e.origin + " or " + e.destination + " does not exist");
        }
        adjList.get(e.origin).remove(e);
        adjList.get(e.destination).remove(e);
    }

}
