package com.aditya.DSA.Algorithm;

import java.util.Arrays;

public class BubbleSort {
    // aka Sinking Sort or Exchange Sort
    // stable, in-place algo
    // Best case: O(N)     sorted array
    // Worst case: O(N^2)  array sorted in reverse order
    // Auxiliary Space: O(1)

    // 4 3 2 5 1
    // i = 0 (first pass)
    // j= 1, 3 4 2 5 1
    // j= 2, 3 2 4 5 1
    // j= 3, 3 2 4 5 1
    // j= 4, 3 2 4 1 5
    // i = 1 (second pass)
    // 2 3 1 4 5
    // i = 2 (third pass)
    // 2 1 3 4 5
    // i = 3 (fourth pass)
    // 1 2 3 4 5
    // i = 4 (fifth pass)
    // swap= false, break

    public static void bubbleSort(int[] nums) {
        int N = nums.length;
        boolean swapped = false;

        // j < N-1 because j+1 in if checks till the last element
        // for optimization, j < N-1 -i
        // because after each pass of i, last element is in its correct order
        // and no need to traverse through them

        for (int i = 0; i<N; i++) {
            for (int j=0; j<N-1 -i ; j++) {
                // if current element is greater than next element, swapped
                if (nums[j] > nums[j+1]) {
                    swapped = true; // flag
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
            // if no swapping is done in the j loop, it means the array is now sorted
            if (!swapped)
                break;
            else
                swapped = false;  // reset the flag
        }
    }

    public static void main(String[] args) {
        int[] nums = { 6, 5, 7, 4, 2, 3, 1};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
