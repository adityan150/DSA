package com.aditya.DSA.leetcode;

// https://practice.geeksforgeeks.org/problems/josephus-problem/1/
public class Josephus {
    public static void main(String[] args) {
        System.out.println("Josephus Problem:");
        int N = 40;
        int K = 7;
        System.out.println("Circle size: "+N+ "\nSkip: "+K+"\nSurvivor: "+josephus(N, K));
    }

    // smaller problem size = n-1
    // eg. n = 7, k = 2
    // Problem:      1  2  3  4  5  6  7
    // Sub-Problem:  3  4  5  6  7  1      (2 eliminated)
    // then, N = (n + K-1 ) % N +1
    // K-1 steps in one recursion
    // %N to move in circle
    // +1 : % starts from 0, +1 because index starts from 1
    public static int josephus(int N, int K) {
        if (N == 1) {
            return 1;
        }
        return (josephus(N-1, K) + K -1) % N +1;
    }
}
