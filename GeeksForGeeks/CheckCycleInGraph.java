package com.aditya.DSA.GeeksForGeeks;

import java.util.ArrayList;

public class CheckCycleInGraph {

    public static void main(String[] args) {
        // graph of 5 vertices
        Graph g = new Graph(6);


        g.addVertex(0, 1);
        g.addVertex(0, 2);
        g.addVertex(1, 3);
        g.addVertex(1, 4);
        g.addVertex(3, 5);

        System.out.println(g.checkCycle());

    }

    private static class Graph {
        int V;
        ArrayList<ArrayList<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);

            for (int i = 0; i < V; i++ ) {
                adj.add(new ArrayList<>());
            }
        }
        // add vertex in graph
        void addVertex(int u, int v) {
            adj.get(u).add(v);
        }

        // check cycle in graph
        boolean checkCycle() {
            boolean[] visited = new boolean[V];

            return DFSUtil(0, visited);
        }
        boolean DFSUtil(int s, boolean[] visited) {
            if (visited[s]) {
                return true;
            }
            else {
                visited[s] = true;

                for (int i = 0; i < adj.get(s).size(); i++) {
                    boolean flag = DFSUtil(adj.get(s).get(i), visited);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }


    }

}
