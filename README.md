Assignment 4: Graph Traversal and Representation System

I implemented BFS and DFS traversal algorithms on a graph stored as an adjacency list.
I tested them on random directed graphs with 10, 30, and 100 vertices using System.nanoTime().

Here is my result:

![Result](Result.png)

What I learned:
DFS was slightly faster because it does not use a queue. Both scale linearly with graph size,
matching O(V + E) complexity. BFS is better for shortest path, DFS for deep exploration.
Main challenge was separating traversal logic from time measurement.

Screenshots:

![Vertex](Vertex.png)
![Edge](Edge.png)
![Graph Part 1](Graph_1_part.png)
![Graph Part 2](Graph_2_part.png)
![Graph Part 3](Graph_3_part.png)
![Main](Main.png)
![Experiment Part 1](Experiment_1_part.png)
![Experiment Part 2](Experiment_2_part.png)
![Result](Result.png)

