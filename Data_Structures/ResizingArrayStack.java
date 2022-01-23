package com.aditya.DSA.Data_Structures;

import java.util.Iterator;
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] a = (Item[]) new Object[1];   // Stack of items, capacity = 1
    private int N = 0;                           // Number of items

    public boolean isEmpty() { return N == 0; }
    public int size()        { return N;      }

    private void resize(int max) {
        // Move stack to a new array of size max
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    public void push(Item item) {
        // Add item to top of stack
        // double the capacity if array is full
        if (N == a.length) resize(2*a.length);
        a[N++] = item;
    }

    public Item pop() {
        // Remove item from top of stack
        Item item = a[--N];
        a[N] = null;            // Avoid loitering
        // halve the capacity if items are only a quarter of capacity
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        // Support LIFO iteration
        private int i = N;
        public boolean hasNext() { return i > 0;    }
        public    Item next()    { return a[--i];   }
        public    void remove()  {                  }
        /*
        remove() intentionally left blank
        Interleaving iteration with operations that modify data structure
        is not recommended
        */
    }
}
