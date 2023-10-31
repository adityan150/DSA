package Leetcode;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] nums = { 4, 10, 6, 5, 18, 8};
        int k = 9;
        System.out.println(checkSubarraySum(nums, k));
    }

    public static boolean checkSubarraySum2(int[] nums, int k) {
        int prefixSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum += nums[i];

            // two consecutive zeros
            if (nums[i-1] == 0 && nums[i] == 0) return true;
            // current sum divisible by k
            else if (prefixSum % k == 0) return true;

            // check all subarrays till index i
            int innerSum = prefixSum;
            int j = 0;

            while (innerSum >= k && i - j >= 2) {
                innerSum -= nums[j];
                // if sum of subarray divisible by k
                if (innerSum % k == 0)  return true;
                j++;
            }
        }
        return false;
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        // Store remainders of cumulative sums divided by k
        HashMap<Integer, Integer> rem = new HashMap<>();
        int previousSum = 0;
        rem.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            previousSum += nums[i];
            int remainder = previousSum % k;

            if (!rem.containsKey(remainder))
                rem.put(remainder, i);

                // if remainder is already present in map and the difference of the
                // indices of equal remainders is at least 2
            else if (i - rem.get(remainder) >= 2)
                return true;
        }
        return false;
    }
}
