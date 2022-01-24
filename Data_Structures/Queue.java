package com.aditya.DSA.Data_Structures;

import java.util.Iterator;

public class Queue<Item> implements Iterable{

    private Node first;           // link to least recently added node
    private Node last;            // link to most recently added node
    private int N;                // no. of elements in queue

    private class Node{
        // nested class to define Nodes
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }  //Or: N==0
    public     int size()    { return N;           }

    public void enqueue(Item item) {
        // Add item to the end of the list
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
    }
    public Item dequeue() {
        // Remove item from beginning of the list
        Item item = first.item;
        first = first.next;
        if (isEmpty())  last = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = last;

        public boolean hasNext() { return current.next != null; }
        public void remove() {}

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
