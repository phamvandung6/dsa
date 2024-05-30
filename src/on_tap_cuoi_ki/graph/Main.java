package on_tap_cuoi_ki.graph;

public class Main {
    public static void main(String[] args) {
        UndirectedGraph<String> graph = new UndirectedGraph<>();

        Vertex<String> v1 = graph.insertVertex("A");
        Vertex<String> v2 = graph.insertVertex("B");
        Vertex<String> v3 = graph.insertVertex("C");

        Edge<String> e1 = graph.insertEdge(v1, v2, 1.0);
        Edge<String> e2 = graph.insertEdge(v2, v3, 2.0);
        Edge<String> e3 = graph.insertEdge(v1, v3, 3.0);

        System.out.println("Number of vertices: " + graph.numVertices());
        System.out.println("Vertices: " + graph.vertices());
        System.out.println("Number of edges: " + graph.numEdges());
        System.out.println("Edges: " + graph.edges());
        System.out.println("Edge between vertices A and B: " + graph.getEdge(v1, v2));
        System.out.println("End vertices of edge AB: " + graph.endVertices(e1));
        System.out.println("Opposite vertex of vertex B in edge AB: " + graph.opposite(v2, e1));
        System.out.println("Out degree of vertex A: " + graph.outDegree(v1));
        System.out.println("In degree of vertex C: " + graph.inDegree(v3));
        System.out.println("Outgoing edges of vertex A: " + graph.outgoingEdges(v1));
        System.out.println("Incoming edges of vertex C: " + graph.incomingEdges(v3));

        graph.removeVertex(v2);
        System.out.println("Number of vertices after removing vertex B: " + graph.numVertices());
        System.out.println("Vertices after removing vertex B: " + graph.vertices());

        graph.removeEdge(e3);
        System.out.println("Number of edges after removing edge AC: " + graph.numEdges());
        System.out.println("Edges after removing edge AC: " + graph.edges());
    }
}
