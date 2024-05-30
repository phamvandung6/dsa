package thuchanh.tuan9.bai4;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        // Tạo đồ thị
        // Xem đồ thị trực quan ở image.png
        Graph<String> graph = new Graph<>();
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");
        Vertex<String> F = new Vertex<>("F");

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);
        graph.addVertex(F);

        graph.addEdge(new Edge<>(A, B, 1));
        graph.addEdge(new Edge<>(A, C, 2));
        graph.addEdge(new Edge<>(B, F, 5));
        graph.addEdge(new Edge<>(C, D, 4));
        graph.addEdge(new Edge<>(C, E, 3));
        graph.addEdge(new Edge<>(B, D, 6));

        // Duyệt đồ thị DFS
        System.out.println("Duyệt đồ thị DFS: ");
        graph.dfs(A);
        System.out.println();
        // Duyệt đồ thị BSF
        System.out.println("Duyệt đồ thì BFS");
        graph.bfs(A);
        System.out.println();

        // Tìm đường đi ngắn nhất từ đỉnh u với đỉnh v trên đồ thị cô hướng, có trọng số
        // bằng thuật toán Dijkstra.
        Dijkstra<String> dijkstra = new Dijkstra<>();
        List<Vertex<String>> result = dijkstra.dijkstra(graph, A, D);

        StringBuilder sb = new StringBuilder();
        for (Vertex<String> vertex : result) {
            sb.append(vertex.element).append(" -> ");
        }
        System.out.println("Đường đi ngắn nhất từ A đến D là: ");
        System.out.println(sb.toString());

        // Tạo đồ thị mới
        Graph<String> graph2 = new Graph<>();

        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");

        graph2.addVertex(v1);
        graph2.addVertex(v2);
        graph2.addVertex(v3);
        graph2.addVertex(v4);

        graph2.addEdge(new Edge<>(v1, v2, 1));
        graph2.addEdge(new Edge<>(v2, v3, 1));
        graph2.addEdge(new Edge<>(v3, v4, 1));
        graph2.addEdge(new Edge<>(v4, v1, 1));
        graph2.addEdge(new Edge<>(v1, v3, 1));

        // Tìm đường đi halminton
        graph2.hamiltonianPathExists();
        graph2.hamiltonianCycleExists();

    }
}
