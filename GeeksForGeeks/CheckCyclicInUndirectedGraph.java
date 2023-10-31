package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Iterator;

public class CheckCyclicInUndirectedGraph {

    private class UndirectedGraph {
        int V;
        ArrayList<ArrayList<Integer>> adj;

        UndirectedGraph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }
        void addEdge(int a, int b) {
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean isCyclic() {
            boolean[] visited = new boolean[V];

            for (int i = 0; i < adj.size(); i++) {
                if (!visited[i]) {
                    if (isCyclicUtil(i, -1, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean isCyclicUtil(int vertex, int parent, boolean[] visited) {
            visited[vertex] = true;

            ArrayList<Integer> list = adj.get(vertex);
            for (int i: list) {
                if (!visited[i]) {
                    if (isCyclicUtil(i, vertex, visited))
                        return true;
                }
                else if (i != parent) {
                    return true;
                }
            }
            return false;
        }

    }
}
