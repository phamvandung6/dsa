package thuchanh.tuan9.bai1;

public class Client {
    public static void main(String[] args) {
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();

        // Thêm các đỉnh vào đồ thị
        Vertex<Integer> v1 = graph.insertVertex(1);
        Vertex<Integer> v2 = graph.insertVertex(2);
        Vertex<Integer> v3 = graph.insertVertex(3);
        Vertex<Integer> v4 = graph.insertVertex(4);
        Vertex<Integer> v5 = graph.insertVertex(5);

        // Thêm các cạnh vào đồ thị
        graph.insertEdge(v1, v2);
        graph.insertEdge(v2, v3);
        graph.insertEdge(v3, v4);
        graph.insertEdge(v4, v1);
        graph.insertEdge(v1, v3);
        graph.insertEdge(v2, v4);
        graph.insertEdge(v2, v5);

        // In ra danh sách đỉnh và cạnh
        System.out.println("Danh sách các đỉnh:");
        for (Vertex<Integer> vertex : graph.vertices()) {
            System.out.print(vertex.element + " ");
        }
        System.out.println();

        System.out.println("Danh sách các cạnh:");
        for (Edge<Integer> edge : graph.edges()) {
            System.out.println("(" + edge.origin.element + ", " + edge.destination.element + ")");
        }

        // Tìm các đỉnh kề và cạnh kề với đỉnh v2
        Vertex<Integer> u = v2;
        System.out.println("Các đỉnh kề với đỉnh " + u.element + ":");
        for (Edge<Integer> edge : graph.outgoingEdges(u)) {
            System.out.print(edge.destination.element + " ");
        }
        System.out.println();

        System.out.println("Các cạnh kề với đỉnh " + u.element + ":");
        for (Edge<Integer> edge : graph.outgoingEdges(u)) {
            System.out.println("(" + edge.origin.element + ", " + edge.destination.element + ")");
        }
    }
}
