package thuchanh.tuan9.bai2;

import thuchanh.tuan9.bai1.Edge;
import thuchanh.tuan9.bai1.Vertex;

public class Client {
    public static void main(String[] args) {
        WeightedUndirectedGraph<String> graph = new WeightedUndirectedGraph<>();

        // Thêm các đỉnh vào đồ thị
        Vertex<String> v1 = graph.insertVertex("A");
        Vertex<String> v2 = graph.insertVertex("B");
        Vertex<String> v3 = graph.insertVertex("C");
        Vertex<String> v4 = graph.insertVertex("D");

        // Thêm các cạnh vào đồ thị
        graph.insertEdge(new Edge<String>(v1, v2, 1));
        graph.insertEdge(new Edge<String>(v2, v3, 2));
        graph.insertEdge(new Edge<String>(v3, v4, 3));
        graph.insertEdge(new Edge<String>(v4, v1, 4));

        // In ra danh sách đỉnh và cạnh
        System.out.println("Danh sách các đỉnh:");
        for (Vertex<String> vertex : graph.vertices()) {
            System.out.print(vertex.element + " ");
        }
        System.out.println();

        System.out.println("Danh sách các cạnh:");
        for (Edge<String> edge : graph.edges()) {
            System.out.println("(" + edge.origin.element + ", " + edge.destination.element + ", " + edge.weight + ")");
        }

        // Tìm các đỉnh kề và cạnh kề với đỉnh v2
        Vertex<String> u = v2;
        System.out.println("Các đỉnh kề với đỉnh " + u.element + ":");
        for (Edge<String> edge : graph.outgoingEdges(u)) {
            System.out.print(edge.destination.element + " ");
        }
        System.out.println();

        System.out.println("Các cạnh kề với đỉnh " + u.element + ":");
        for (Edge<String> edge : graph.outgoingEdges(u)) {
            System.out.println("(" + edge.origin.element + ", " + edge.destination.element + ")");
        }
    }
}
