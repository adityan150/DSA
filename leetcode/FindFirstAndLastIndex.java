package com.aditya.DSA.leetcode;
// Question 34
public class FindFirstAndLastIndex {
    public static int[] searchRange(int[] nums, int target) {
        int[] minMax= { -1, -1};

        minMax[0] = binarySearch(nums, target, true);
        minMax[1] = binarySearch(nums, target, false);
        return minMax;
    }

    public static int binarySearch(int[] nums, int target,boolean findFirst) {
        int mid = 0;
        int lo = 0;
        int hi = nums.length-1;
        int result = -1;

        while(lo <= hi) {
            mid = lo + (hi - lo) /2;

            if(nums[mid] == target) {
                result = mid;
                if(findFirst)
                    hi = mid -1;
                else
                    lo = mid + 1;
            }
            else if(nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7, 8, 9};
        int target = 7;
        int[] result = searchRange(nums, target);
        System.out.println(result[0] + ", "+ result[1]);
    }

    //    public static int[] searchRange(int[] nums, int target) {
//        int[] minMax= { -1, -1};
//
//        if(nums.length == 0)
//            return minMax;
//
//        else if(nums.length == 1) {
//            if(nums[0] != target)
//                return minMax;
//            else {
//                minMax[0] = 0;
//                minMax[1] = 0;
//                return minMax;
//            }
//        }
//        minMax[0] = Integer.MAX_VALUE;
//        minMax = binarySearch(nums, target, 0, nums.length-1, minMax);
//        if(minMax[0] == Integer.MAX_VALUE)
//            minMax[0] = -1;
//        return minMax;
//
//    }
//
//    public static int[] binarySearch(int[] nums, int target, int lo, int hi, int[] minMax) {
//        int mid = 0;
//
//        while(lo <= hi && lo >= 0 && hi < nums.length) {
//            mid = lo + (hi - lo) /2;
//
//            if(nums[mid] == target) {
//                if(mid < minMax[0])
//                    minMax[0] = mid;
//                if(mid > minMax[1])
//                    minMax[1] = mid;
//                int[] temp = binarySearch(nums, target, lo, mid-1, minMax);
//                temp = binarySearch(nums, target, mid+1, hi, temp);
//
//                if(temp[0] < minMax[0])
//                    minMax[0] = temp[0];
//                if(temp[1] > minMax[1])
//                    minMax[1] = temp[1];
//                return minMax;
//            }
//
//            else if(nums[mid] > target)
//                hi = mid - 1;
//            else
//                lo = mid + 1;
//        }
//        return minMax;
//    }
}
