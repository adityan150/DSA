package com.aditya.DSA.Algorithm.Array;

import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] arr, int lo, int mid, int hi) {
        int n1 = mid - lo + 1;        // length of left sub-array
        int n2 = hi - mid;            // length of right sub-array

        /* Create temporary arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; i++)
            L[i] = arr[lo + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indices of first and second sub-array
        int i = 0, j = 0;

        // Initial index of merged sub-array
        int k = lo;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            // mid point
            int mid = lo + (hi - lo)/2;

            // sort first and second halves
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid+1, hi);

            // Merge the sorted halves
            merge(arr, lo, mid, hi);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 8, 2, 1, 4, 9, 0, 3, 7, 6, 5};

        mergeSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}
