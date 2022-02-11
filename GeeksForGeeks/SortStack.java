package com.aditya.DSA.GeeksForGeeks;

import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/sort-a-stack

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int j = 6050; j > 0; j--)
            s.push(j);
        System.out.println(s);
        s = sort(s);
        System.out.println(s);
    }
    public static Stack<Integer> sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int top = s.pop();
            s = sort(s);
            sortedInsert(s, top);
        }
        return s;
    }
    public static Stack<Integer> sortedInsert(Stack<Integer> s, int top) {
        if (s.isEmpty() || top > s.peek()) {
            s.push(top);
        }
        else {
            int temp = s.pop();
            sortedInsert(s, top);
            s.push(temp);
        }
        return s;
    }

//  public static Stack<Integer> sort(Stack<Integer> s) {
//        if (s.size() == 1)
//            return s;
//
//        int top = s.pop();
//        Stack<Integer> temp = new Stack<>();
//        s = sort(s);
//        while (!s.isEmpty() && top < s.peek()) {
//            temp.push(s.pop());
//        }
//        s.push(top);
//        while (!temp.isEmpty()) {
//            s.push(temp.pop());
//        }
//        return s;
//    }
}
