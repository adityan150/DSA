package GeeksForGeeks;

import java.util.ArrayList;

public class GraphDFS {

    private static class Graph {
        private int V;  //  No. of vertices
        private ArrayList<ArrayList<Integer>> adj;     // Adjacency lists

        // Constructor
        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);

            for (int i = 0; i < V; i++) {
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

        // DFS traversal from source s
        void DFS(int s) {
            // boolean array to keep track of visited vertices (false by default)
            boolean[] visited = new boolean[V];

            DFSUtil(s, visited);

            // handle disconnected graph by calling DFS on unvisited vertices
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    DFSUtil(i, visited);
                }
            }

            System.out.println();
        }
        // recursive utility function
        void DFSUtil(int s, boolean[] visited) {
            if (!visited[s]) {
                // vertex not visited yet
                System.out.print(s + " ");
                visited[s] = true;

                // call DFS on connected vertices
                for (int i = 0; i < adj.get(s).size(); i++) {
                    DFSUtil(adj.get(s).get(i), visited);
                }
            }
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

        g.DFS(4);

    }
}
