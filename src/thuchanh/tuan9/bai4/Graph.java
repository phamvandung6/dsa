package thuchanh.tuan9.bai4;

import java.util.*;

public class Graph<T> {
    public Map<Vertex<T>, List<Edge<T>>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex<T> vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Edge<T> edge) {
        adjacencyList.get(edge.origin).add(edge);
        adjacencyList.get(edge.destination).add(new Edge<>(edge.destination, edge.origin, edge.weight));
    }

    public List<Edge<T>> getEdges(Vertex<T> vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    public Set<Vertex<T>> getVertices() {
        return adjacencyList.keySet();
    }

    public void printAdjacencyList() {
        for (Map.Entry<Vertex<T>, List<Edge<T>>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey().element + " -> ");
            for (Edge<T> edge : entry.getValue()) {
                System.out.print(edge.destination.element + " " + edge.weight + " ");
            }
            System.out.println();
        }
    }

    public void dfs(Vertex<T> start) {
        Set<Vertex<T>> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(Vertex<T> current, Set<Vertex<T>> visited) {
        if (current == null || visited.contains(current)) {
            return;
        }

        visited.add(current);
        System.out.print(current.element + " ");

        for (Edge<T> edge : getEdges(current)) {
            dfsHelper(edge.destination, visited);
        }
    }

    public void bfs(Vertex<T> start) {
        Set<Vertex<T>> visited = new HashSet<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            System.out.print(current.element + " ");
            for (Edge<T> edge : getEdges(current)) {
                if (!visited.contains(edge.destination)) {
                    queue.add(edge.destination);
                    visited.add(edge.destination);
                }
            }
        }
    }

    // Hàm tìm đường đi Hamilton
    public boolean hamiltonianPathExists() {
        List<Vertex<T>> path = new ArrayList<>();
        for (Vertex<T> vertex : adjacencyList.keySet()) {
            path.add(vertex);
            if (hamiltonianPathHelper(vertex, path)) {
                System.out.println("Hamiltonian Path: " + Arrays.toString(path.toArray()));
                return true;
            }
            path.remove(path.size() - 1);
        }
        return false;
    }

    private boolean hamiltonianPathHelper(Vertex<T> current, List<Vertex<T>> path) {
        if (path.size() == adjacencyList.size()) {
            return true;
        }
        for (Edge<T> edge : getEdges(current)) {
            if (!path.contains(edge.destination)) {
                path.add(edge.destination);
                if (hamiltonianPathHelper(edge.destination, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    // Hàm tìm chu trình Hamilton
    public boolean hamiltonianCycleExists() {
        List<Vertex<T>> path = new ArrayList<>();
        Vertex<T> start = null;

        // Lấy một đỉnh bất kỳ làm điểm bắt đầu
        for (Vertex<T> vertex : adjacencyList.keySet()) {
            start = vertex;
            break;
        }

        if (start == null) {
            return false;
        }

        path.add(start);
        if (hamiltonianCycleHelper(start, path)) {
            System.out.println("Hamiltonian Cycle: " + Arrays.toString(path.toArray()));
            return true;
        }
        return false;
    }

    private boolean hamiltonianCycleHelper(Vertex<T> current, List<Vertex<T>> path) {
        // Nếu tất cả các đỉnh đã được thăm
        if (path.size() == adjacencyList.size()) {
            // Kiểm tra xem có cạnh từ đỉnh cuối cùng đến đỉnh đầu tiên không
            for (Edge<T> edge : getEdges(current)) {
                if (edge.destination.equals(path.get(0))) {
                    path.add(path.get(0)); // Thêm đỉnh đầu tiên vào cuối để tạo thành chu trình
                    return true;
                }
            }
            return false;
        }

        // Thử tất cả các đỉnh kề với đỉnh hiện tại
        for (Edge<T> edge : getEdges(current)) {
            if (!path.contains(edge.destination)) {
                path.add(edge.destination);
                if (hamiltonianCycleHelper(edge.destination, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}
