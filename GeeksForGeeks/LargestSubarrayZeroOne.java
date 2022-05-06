package com.aditya.DSA.GeeksForGeeks;

import java.util.HashMap;

public class LargestSubarrayZeroOne {
    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 0, 1, 1, 1, 1, 0, 1};
        int N = arr.length;
        System.out.println(maxLen(arr, N));
    }

    static int maxLen(int[] arr, int N)
    {
        int max = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) prefixSum--;
            else prefixSum++;

            if (prefixSum == 0) {
                max = i + 1;
            }
            else {
                if (!map.containsKey(prefixSum)) {
                    map.put(prefixSum, i);
                }
                else {
                    max = Math.max(max, i - map.get(prefixSum));
                }
            }
        }
        return max;
    }
}
