package GeeksForGeeks;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

    private static class Graph {
        private int V;  //  No. of vertices
        private ArrayList<ArrayList<Integer>> adj;     // Adjacency lists

        // Constructor
        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);

            for (int i = 0; i < V; i++ ) {
                adj.add(new ArrayList<>());
            }
        }

        // Add vertices in the graph
        void addVertices(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Display adjacency lists
        void printGraph() {
            for (int i = 0; i < adj.size(); i++) {
                System.out.println("Adjacency list " + i);
                System.out.print("head ");
                for (int j = 0; j < adj.get(i).size(); j++) {
                    System.out.print(" -> " + adj.get(i).get(j));
                }
                System.out.println();
            }
        }

        // BFS traversal from source s
        void BFS(int s){
            System.out.println("BFS Traversal:");
            // boolean array to store whether a vertex is visited or not, false by default
            boolean[] visited = new boolean[V];

            Queue<Integer> bfsQueue = new LinkedList<>();
            bfsQueue.add(s);
            visited[s] = true;

            while (!bfsQueue.isEmpty()) {
                s = bfsQueue.poll();
                System.out.print(s + " ");

                // get all the adjacent vertices of the dequeued item s
                for (int i = 0; i < adj.get(s).size(); i++) {
                    int n = adj.get(s).get(i);
                    if (!visited[n]) {
                        visited[n] = true;
                        bfsQueue.add(n);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addVertices(0, 1);
        g.addVertices(0, 2);
        g.addVertices(1, 3);
        g.addVertices(1, 4);
        g.addVertices(2, 3);
        g.addVertices(3, 5);
        g.addVertices(4, 5);

        g.BFS(4);

    }
}
