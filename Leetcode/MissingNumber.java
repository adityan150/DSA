package Leetcode;
// https://leetcode.com/problems/missing-number/
public class MissingNumber {

    // nums[] has numbers in the range 0 to N+1 in an array of size N
    // find the missing number
    public static int missingNumber(int[] nums) {
        int N = nums.length;
        int i = 0;
        // sort the array
        while (i < N) {

            if (nums[i] < N && nums[i] != i)
                swap(nums, i, nums[i]);
            else
                i++;
        }
        // check the missing number
        for(i=0; i<N; i++) {
            if (nums[i] != i)
                return i;
        }
        return N;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 4, 2, 3, 1};
        System.out.println(missingNumber(nums));
    }
}
