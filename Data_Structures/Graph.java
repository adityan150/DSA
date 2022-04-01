package com.aditya.DSA.Data_Structures;

import java.util.ArrayList;

public class Graph {
    public static void main(String[] args) {
        // graph of 5 vertices
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addVertex(adj, 0, 1);
        addVertex(adj, 0, 2);
        addVertex(adj, 1, 3);
        addVertex(adj, 1, 4);
        addVertex(adj, 2, 3);
        addVertex(adj, 3, 5);
        addVertex(adj, 4, 5);



        printGraph(adj);
    }

    static void addVertex(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Adjacency list of " + i);
            System.out.print("Head ");

            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }
}
