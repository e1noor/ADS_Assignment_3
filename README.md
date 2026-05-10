Assignment 4: Graph Traversal and Representation System

Project Overview
----------------
I created a graph data structure and implemented two traversal algorithms:
BFS (Breadth-First Search) and DFS (Depth-First Search).

A graph is made of vertices (nodes) and edges (connections).
I used an adjacency list to store the graph: each vertex keeps a list of edges
that go out from it.

BFS visits neighbours level by level using a queue.
DFS goes deep along one branch before backtracking (I used recursion).

I tested both algorithms on directed graphs with 10, 30, and 100 vertices.
I measured execution time in nanoseconds using System.nanoTime().

Class Descriptions
------------------
Vertex class
- Just an id number.
- Constructor, getId(), toString().

Edge class
- Contains source vertex and destination vertex.
- Constructor, getters, toString().

Graph class
- The main class that holds the adjacency list (Map of Vertex to List of Edge).
- Methods: addVertex, addEdge, printGraph.
- Traversal methods: bfs(start), dfs(start) – these print the order.
- I also added bfsOrder(start) and dfsOrder(start) that return a list of ids
  without printing, so I can measure pure performance.

Experiment class
- Generates random graphs with a given number of vertices and average out-degree.
- Has runMultipleTests() that tests sizes 10, 30, 100.
- Uses System.nanoTime() before and after traversal to measure time.

Algorithm Descriptions
----------------------
BFS:
1. Start from source, mark visited, add to queue.
2. While queue not empty:
    - Remove the front vertex.
    - For each unvisited neighbour, mark visited and add to queue.
3. Order is level by level.
   Complexity: O(V + E).
   Use when you need shortest path in unweighted graphs.

DFS:
1. Start from source, mark visited.
2. Recursively visit the first unvisited neighbour.
3. Continue until all reachable vertices are visited.
4. Order is depth-first.
   Complexity: O(V + E).
   Use for topological sort, cycle detection, maze solving.

Experimental Results
--------------------
I ran tests on random directed graphs. Here are the times I got:

Graph with 10 vertices:
BFS time: 46100 ns
DFS time: 21900 ns

Graph with 30 vertices:
BFS time: 48900 ns
DFS time: 31500 ns

Graph with 100 vertices:
BFS time: 96600 ns
DFS time: 75400 ns

The exact table is also in the screenshot, but clearly time grows as the graph gets bigger.
Both algorithms scale roughly linearly, which matches O(V + E).

On the small fixed 10-vertex graph (shown in the screenshot),
BFS traversal order was: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
DFS traversal order was: 0, 1, 3, 7, 8, 9, 4, 2, 5, 6
You can see BFS goes level by level, DFS goes deep first.

Screenshots
-----------
Here are the screenshots I included in my repository:

- graph_structure.png – printed adjacency list for the demo graph
- bfs_output.png – BFS traversal order
- dfs_output.png – DFS traversal order
- performance.png – execution time results for 10, 30, 100 vertices
- main_output.png – full console output of the program

All screenshots are inside the docs/screenshots folder.

Reflection
----------
What I learned:
- The same graph can be explored in very different orders depending on the algorithm.
- BFS uses a queue and goes wide; DFS uses recursion and goes deep.
- BFS finds the shortest path in an unweighted graph, but DFS cannot guarantee that.
- DFS might cause stack overflow if the graph is very deep, so an iterative version would be safer.

Challenges:
- Making sure I didn’t reuse printed output for time measurement. I created separate
  methods (bfsOrder, dfsOrder) that just return the list, so timing is accurate.
- Generating random graphs that are connected enough to be interesting but not too dense.
- Understanding how the adjacency list should store edges – I used directed edges.

The results match what I expected from Big-O: O(V+E) for both traversals.
DFS was slightly faster in my tests, probably because it doesn't need a queue data structure.

GitHub Commit History
---------------------
My commits followed a clear order:
1. init: project structure
2. feat(vertex): implemented Vertex class
3. feat(edge): added Edge class
4. feat(graph): added adjacency list and empty traversal methods
5. feat(traversal): completed BFS and DFS
6. feat(experiment): added performance testing
7. docs(readme): added analysis and results
8. release: v1.0