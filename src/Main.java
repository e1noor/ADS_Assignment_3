public class Main {
    public static void main(String[] args) {
        System.out.println("=== Small Graph (10 vertices) Demonstration ===");
        Graph smallGraph = buildSmallGraph();
        smallGraph.printGraph();

        System.out.println();
        smallGraph.bfs(0);
        smallGraph.dfs(0);

        Experiment exp = new Experiment();
        exp.runMultipleTests();
    }


    private static Graph buildSmallGraph() {
        Graph g = new Graph();
        for (int i = 0; i < 10; i++) {
            g.addVertex(new Vertex(i));
        }
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 7);
        g.addEdge(5, 8);
        g.addEdge(6, 9);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        return g;
    }
}