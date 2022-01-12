package com.aditya.leetcode;
// question 33
public class FindInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if(nums.length ==1) {
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }

        int pivot = findPivot(nums);
        // array not rotated
        if(pivot == -1)
            return binarySearch(nums, target, 0, nums.length - 1);
        else if(target >= nums[0])
            return binarySearch(nums, target, 0, pivot);
        else
            return binarySearch(nums, target, pivot+1, nums.length-1);
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

    public static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        int mid;

        if(nums[end] > nums[start])
            return end;

        while(start <= end) {
            mid = start + (end - start)/2;

            // mid is the pivot
            if(mid < end && nums[mid] > nums[mid+1])
                return mid;
            // mid-1 is the pivot
            else if(mid > start && nums[mid] < nums[mid-1])
                return mid-1;

            // if middle element is smaller than start element, start will be greater than all the elements after middle
            // example : 5 6 1 2 3 4  (mid = 2, start = 5)
            // since 1<5; all elements after 1 will be smaller than 5;
            // change end to mid-1 to move towards maximum number in array
            else if(nums[mid] <= nums[start])
                end = mid - 1;

            // if middle element is greater than start element,
            // change start to middle value to move towards maximum number in array
            else
                start = mid+1;
        }
        return -1;
    }

    // Alternate Method:
    // if target and mid on the same side, use normal binary search
    // else,

    // if target is on the right and mid is on the left,
    // mid = 4, target = 1
    // 4 5 6 7 8 9 10 1 2 3
    // pseudo-array will become like
    // 4 5 6 7 MIN_VALUE 9 10 1 2 3

    // if target is on the left and mid is on the right
    // mid = 4, target = 9
    // 8 9 10 1 2 3 4 5 6 7
    // pseudo-array will become like
    // 8 9 10 MAX_VALUE 2 3 4 5 6 7

    // now we can use normal binary search logic on this arrangement iteratively

    public static int search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;

        while(start <= end) {
            mid = start + (end - start)/2;
            int comparator = nums[mid];

            // check if mid and target both are on same side in rotated array
            if((target < nums[0]  &&  nums[mid] < nums[0]) ||
                    (target >= nums[0]  && nums[mid] >= nums[0]))
                comparator = nums[mid];

                // if target is on the right ascending side and mid is on the left ascending side
                // set the comparator(mid-value) to MIN_VALUE
            else if(target < nums[0])
                comparator = Integer.MIN_VALUE;

                // target on the right side and mid on the left
                // set the comparator(mid-value) to MAX_VALUE
            else
                comparator = Integer.MAX_VALUE;

            // Normal Binary search
            if(target == comparator)
                return mid;
            else if(target > comparator)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        int target = 1;

        System.out.println(search(nums, target));
        System.out.println(search2(nums, target));

    }
}
