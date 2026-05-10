import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Vertex, List<Edge>> adjList;

    public Graph() {
        vertices = new HashMap<>();
        adjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjList.put(v, new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        Vertex v1 = vertices.get(from);
        Vertex v2 = vertices.get(to);
        if (v1 != null && v2 != null) {
            Edge edge = new Edge(v1, v2);
            adjList.get(v1).add(edge);
        }
    }

    public void printGraph() {
        for (Vertex v : adjList.keySet()) {
            System.out.print(v.getId() + " --> ");
            for (Edge edge : adjList.get(v)) {
                System.out.print(edge.getDestination().getId() + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int startID) {
        List<Integer> order = bfsOrder(startID);
        if (order == null) return;
        System.out.println("BFS traversal starting from " + startID + ": " + order);
    }

    public List<Integer> bfsOrder(int startID) {
        Vertex startVertex = vertices.get(startID);
        if (startVertex == null) return null;

        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        List<Integer> order = new ArrayList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            order.add(current.getId());

            for (Edge edge : adjList.get(current)) {
                Vertex neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return order;
    }

    public void dfs(int startID) {
        List<Integer> order = dfsOrder(startID);
        if (order == null) return;
        System.out.println("DFS traversal starting from " + startID + ": " + order);
    }

    public List<Integer> dfsOrder(int startID) {
        Vertex startVertex = vertices.get(startID);
        if (startVertex == null) return null;

        Set<Vertex> visited = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        dfsRecursive(startVertex, visited, order);
        return order;
    }

    private void dfsRecursive(Vertex v, Set<Vertex> visited, List<Integer> order) {
        visited.add(v);
        order.add(v.getId());

        for (Edge edge : adjList.get(v)) {
            Vertex neighbor = edge.getDestination();
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, order);
            }
        }
    }
}