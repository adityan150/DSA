package Algorithm.Array;

import java.util.Arrays;

public class SelectionSort {
    // select the largest/smallest element and place it in the sorted array
    // Best case = Worst case = O(N^2)
    // unstable, in-place
    // Auxiliary space: O(1)
    // performs well on small lists/arrays

    public static void selectionSort(int[] nums) {
        int N = nums.length;

        for (int i = 0; i < N-1; i++) {
            int minIndex = i;
            // traversal through the array to get the index of minimum element
            for (int j = i+1; j < N; j++) {
                if (nums[minIndex] > nums[j])
                    minIndex = j;
            }
            // swap current index with the minimum number
            swap(nums, i, minIndex);
        }
    }

    // swap utility function
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 7, 1, 2, 6, 5};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
