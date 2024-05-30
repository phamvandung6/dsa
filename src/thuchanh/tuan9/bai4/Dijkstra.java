package thuchanh.tuan9.bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;

public class Dijkstra<T> {
    public List<Vertex<T>> dijkstra(Graph<T> graph, Vertex<T> source) {
        List<Vertex<T>> result = new ArrayList<>();
        PriorityQueue<Vertex<T>> queue = new PriorityQueue<>(Comparator.comparingDouble(vertex -> vertex.distance));
        source.distance = 0.0;
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            result.add(current);

            for (Edge<T> edge : graph.adjacencyList.get(current)) {
                Vertex<T> neighbor = edge.destination;
                double newDistance = current.distance + edge.weight;

                if (newDistance < neighbor.distance) {
                    neighbor.distance = newDistance;
                    neighbor.previous = current;
                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }

    public List<Vertex<T>> dijkstra(Graph<T> graph, Vertex<T> source, Vertex<T> destination) {
        List<Vertex<T>> shortestPath = new ArrayList<>();

        // Khởi tạo một PriorityQueue để lưu trữ các đỉnh theo thứ tự tăng dần của
        // khoảng cách
        PriorityQueue<Vertex<T>> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o1.distance, o2.distance));

        // Đặt khoảng cách của đỉnh nguồn là 0 và thêm nó vào hàng đợi
        source.distance = 0.0;
        queue.add(source);

        // Duyệt qua các đỉnh trong hàng đợi cho đến khi hàng đợi trống
        while (!queue.isEmpty()) {
            // Lấy đỉnh hiện tại ra khỏi hàng đợi
            Vertex<T> current = queue.poll();

            // Nếu đỉnh hiện tại là đỉnh đích, dừng thuật toán
            if (current == destination) {
                break;
            }

            // Duyệt qua tất cả các cạnh kề của đỉnh hiện tại
            for (Edge<T> edge : graph.adjacencyList.get(current)) {
                Vertex<T> neighbor = edge.destination;
                double newDistance = current.distance + edge.weight;

                // Nếu khoảng cách mới nhỏ hơn khoảng cách hiện tại của đỉnh kề
                if (newDistance < neighbor.distance) {
                    // Cập nhật khoảng cách mới và đỉnh trước đỉnh kề
                    neighbor.distance = newDistance;
                    neighbor.previous = current;

                    // Thêm neighor vào hàng đợi
                    // queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        // Xây dựng đường đi ngắn nhất từ đỉnh đích đến đỉnh nguồn bằng cách đi ngược
        // lại từ đỉnh đích
        Vertex<T> current = destination;
        while (current != null) {
            shortestPath.add(current);
            current = current.previous;
        }

        // Đảo ngược danh sách để có đường đi từ đỉnh nguồn đến đỉnh đích
        Collections.reverse(shortestPath);

        return shortestPath;
    }

}
