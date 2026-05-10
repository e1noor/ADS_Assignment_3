import java.util.*;

public class Experiment {


    public void runTraversals(Graph g) {
        long bfsTime = measureBFS(g, 0);
        long dfsTime = measureDFS(g, 0);
        System.out.println("BFS time: " + bfsTime + " ns");
        System.out.println("DFS time: " + dfsTime + " ns");
    }


    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};
        System.out.println("\n=== Performance Comparison (time in nanoseconds) ===");
        System.out.printf("%-10s %-15s %-15s%n", "Size", "BFS Time", "DFS Time");

        for (int size : sizes) {
            Graph g = generateRandomGraph(size, 2);
            long bfsTime = measureBFS(g, 0);
            long dfsTime = measureDFS(g, 0);
            System.out.printf("%-10d %-15d %-15d%n", size, bfsTime, dfsTime);
        }
    }


    private Graph generateRandomGraph(int numVertices, int avgOutDegree) {
        Graph g = new Graph();
        for (int i = 0; i < numVertices; i++) {
            g.addVertex(new Vertex(i));
        }
        Random rand = new Random();
        for (int i = 0; i < numVertices; i++) {
            int edges = rand.nextInt(avgOutDegree * 2) + 1;
            for (int j = 0; j < edges; j++) {
                int to = rand.nextInt(numVertices);
                if (to != i) {
                    g.addEdge(i, to);
                }
            }
        }
        return g;
    }

    private long measureBFS(Graph g, int start) {
        long startTime = System.nanoTime();
        g.bfsOrder(start); // используем "тихую" версию
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private long measureDFS(Graph g, int start) {
        long startTime = System.nanoTime();
        g.dfsOrder(start);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public void printResults() {
    }
}