package Algorithm.Array;

import java.util.Arrays;

public class CyclicSort {
    // when given numbers from range 1 to N => use Cyclic Sort
    // given array nums has number ranging from 1 to N
    // index of any value in the array will be value-1
    // since, index of array starts from 0 (self-explanatory)

    // worst case O(N)

    public static void cyclicSort(int[] nums){
        int N = nums.length;
        int i = 0;
        while(i < N-1) {
            int correctIndex = nums[i] -1;
            // check if current element is in its correct index
            if (nums[i] == nums[correctIndex])
                i++;
            else
                swap(nums, i, correctIndex);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 6, 3, 1};
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
