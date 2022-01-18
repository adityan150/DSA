package com.aditya.DSA.leetcode;

public class FindRotationCountOfArray {
    public static int countRotation(int[] nums) {
        // rotation is clockwise
        int pivot = findPivot(nums);

        return pivot+1;
    }

    public static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;

        while(start <= end) {
            mid = start + (end - start) / 2;

            // if mid is the pivot
            if(mid < nums.length - 1 && nums[mid] > nums[mid+1])
                return mid;
            // if mid-1 is the pivot
            else if(mid > 0 && nums[mid] < nums[mid-1])
                return mid - 1;
            // if mid is on the right ascending part of the array
            // move end toward the max element, which is on the left of mid
            else if(nums[start] > nums[mid])
                end = mid -1;
            // else; mid is on the left ascending part of the array
            // nums[start] <= nums[mid] ; which means greater values may lie after mid
            else
                start = mid + 1;
        }
        // if pivot not found
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4};

        System.out.println(countRotation(nums));
    }
}
