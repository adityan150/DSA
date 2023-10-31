package Leetcode;

import java.util.*;

public class NumbersDisappearedFromArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int N = nums.length;
        int i = 0;
        // sort the array
        while (i < N) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex])
                swap(nums, i, correctIndex);
            else
                i++;

        }
        // check the missing numbers and add to the list
        for (i = 0; i < N; i++) {
            if (nums[i] != i+1)
                result.add(i+1);
        }
        return result;
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 3, 2, 1};
        List<Integer> disappered = findDisappearedNumbers(nums);
        System.out.println(disappered.toString());

    }
}
