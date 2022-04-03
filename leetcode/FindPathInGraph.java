package com.aditya.DSA.leetcode;

import java.util.ArrayList;

public class FindPathInGraph {

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,3}, {3,2}, {2,1}, {2,5}, {5,6}, {6,4}, {4,5}};
        System.out.println(validPath(7, edges, 0, 6));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        populateAdjacencyList(adj, edges);
        boolean[] visited = new boolean[n];
        return DFS(adj, visited, source, destination);
    }

    static boolean DFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int source, int destination) {
        if (visited[source]) {
            return false;
        }
        if (source == destination) return true;

        visited[source] = true;
        ArrayList<Integer> edges = adj.get(source);

        if (edges != null) {
            for(int i = 0; i < edges.size(); i++) {
                boolean result = DFS(adj, visited, edges.get(i), destination);
                if (result == true) {
                    return true;
                }
            }
        }
        return false;
    }

    static void populateAdjacencyList(ArrayList<ArrayList<Integer>> adj, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];

            adj.get(from).add(to);
        }
    }
}
