package com.aditya.DSA.leetcode;

//https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/

public class PowerOfNumbers {
    final static int M = 1000000007;
    public static long power(int N, int R) {
        if (R == 0) {
            return 1;
        }
        long temp = (power(N, R/2)) %M;
        temp = (temp*temp)%M;

        if (R % 2 == 0) {
            return temp;
        }
        else {
            return (temp * N) %M;
        }
    }

    public static void main(String[] args) {
        System.out.println(power(10000000, 10000000));
    }
}
