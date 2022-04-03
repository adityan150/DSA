package com.aditya.DSA.Data_Structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphHashMap {

    static class Graph {
        HashMap<Object, LinkedList<Object>> adj = new HashMap<>();
        HashMap<Object, Integer> indices = new HashMap<>();

        Graph(ArrayList<Object> vertices) {
            int index = 0;
            for (int i = 0; i < vertices.size(); i++) {
                Object vertex = vertices.get(i);
                LinkedList<Object> list = new LinkedList<>();
                adj.put(vertex, list);
                indices.put(vertex, index++);
            }
        }

        void addEdge(Object source, Object destination) {
            LinkedList<Object> list = adj.get(source);
            list.addFirst(destination);
            adj.put(source, list);
        }

        void DFS() {
            int N = adj.size();
            boolean[] visited = new boolean[N];

            for (Map.Entry<Object, LinkedList<Object>> entry: adj.entrySet()) {
                Object source = entry.getKey();
                if (!visited[indices.get(source)])
                DFSUtil(source, visited);
            }
        }
        void DFSUtil(Object source, boolean[] visited) {
            // mark this as visited
            visited[indices.get(source)] = true;
            System.out.print(source + " ");
            LinkedList<Object> list = adj.get(source);
            for (int i = 0; i < list.size(); i++) {
                Object destination = list.get(i);
                if (!visited[indices.get(destination)]) {
                    DFSUtil(destination, visited);
                }
            }
        }
        // end of Graph class
    }

    public static void main(String[] args) {
        ArrayList<Object> vertices = new ArrayList<>();
        vertices.add('A');
        vertices.add('B');
        vertices.add('C');
        vertices.add('D');
        vertices.add('E');
        vertices.add('F');
        Graph graph = new Graph(vertices);
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'F');
        graph.addEdge('B', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'D');
        graph.addEdge('D', 'E');
        graph.addEdge('F', 'B');
        graph.addEdge('F', 'E');

        graph.DFS();
    }
}
