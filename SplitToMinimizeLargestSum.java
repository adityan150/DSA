package com.aditya.leetcode;
// https://leetcode.com/problems/split-array-largest-sum/
// Q410
public class SplitToMinimizeLargestSum {
    // split array in m parts to minimize the largest sum among m sub arrays
    // m lies in set (1, N) where N is the size of the array
    // when m = 1; there is only one way to split the array, which is the original array itself
    // there is only one sum (sum of all the elements) which is therefore the largest
    // when m = N; there are N parts of the array, can be done in one way only
    // the largest sum means maximum value in the array
    // Hence, the largest sum lies in the range {Max element, Sum of all elements}
    // Minimize it for the given value of m

    public static int splitArray(int[] nums, int m) {
        int lo = 0;
        int hi = 0;
        int mid;
        // lo will be the max element in the array
        // hi will be the sum of all elements
        for(int e : nums) {
            lo = Math.max(lo, e);
            hi += e;
        }

        while(lo < hi) {
            mid = lo + (hi - lo) /2;

            // count the number of sub-arrays: arrays with max sum mid
            int sum = 0;
            int subarrays = 1;
            for(int e: nums) {
                // if adding current element in the sum exceeds max sum
                // increase sub-arrays array count and restart counting sum from current element
                if(sum + e > mid) {
                    subarrays++;
                    sum = e;
                }
                // else proceed to find the max sum
                else
                    sum += e;
            }
            // if no. of sub-arrays is greater than m, increase the max sum to decrease no. of subarrays-arrays
            // set lo = mid
            if(subarrays > m)
                lo = mid + 1;
            else
                hi = mid;
        }
        // at the end lo = hi = answer; since answer surely exists
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8};
        int m = 2;
        System.out.println(splitArray(nums, m));
    }
}
