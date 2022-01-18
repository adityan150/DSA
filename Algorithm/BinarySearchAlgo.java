package com.aditya.DSA.Algorithm;

public class BinarySearchAlgo {
    public static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        return binarySearch(nums, target, start, end);
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {
        int mid;

        while(start <= end) {
            mid = start + (end - start)/2;

            if(nums[mid] > target)
                end = mid - 1;
            else if(nums[mid] < target)
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static int descendingBinarySearch(int[] nums, int target, int start, int end) {
        int mid;

        while(start <= end) {
            mid = start + (end - start) /2;

            if(nums[mid] > target)
                start = mid + 1;
            else if(nums[mid] < target)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static int orderAgnosticBinarySearch(int[] nums, int target, int start, int end) {
        if(nums[start] <= nums[end])
            return binarySearch(nums, target, start, end);
        else
            return descendingBinarySearch(nums, target, start, end);
    }
}
