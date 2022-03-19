package com.aditya.DSA.Algorithm.Array;

import java.util.Arrays;

public class InsertionSort {

    // insert the current element in its correct position in sorted array
    // best O(N)
    // worst O(N^2)
    // auxiliary space O(1)
    // use cases:
    // adaptive: steps get reduced if array is sorted
    // stable; used for smaller values of N;
    // used in hybrid sorting algorithms

    public static void insertionSort(int[] nums) {
        int N = nums.length;

        for(int i = 0; i<N-1; i++) {
            for(int j = i+1; j > 0; j--) {
                if (nums[j] < nums[j-1])
                    swap(nums, j, j-1);
                else break;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 8, 7, 2, 1};
        insertionSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
