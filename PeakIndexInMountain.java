package com.aditya.leetcode;
// Question 852
public class PeakIndexInMountain {
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while(start < end) {
            mid = start + (end - start)/2;

            // mid+1 will never go outOfBounds, unlike mid-1
            // because number will always be one less than the last index while start != end
            // example if last index is 9, start= 8, end = 9, then (8+9)/2 = 8

            //descending part of the array
            if(arr[mid] > arr[mid+1]) {
                end = mid;
            }
            //ascending part of the array
            else
                start = mid + 1;
        }
        // start = end for the max element
        return start;
    }
}
