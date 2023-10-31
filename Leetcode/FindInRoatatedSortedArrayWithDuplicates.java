package Leetcode;

public class FindInRoatatedSortedArrayWithDuplicates {
    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        System.out.println(pivot);
        
        // if no pivot found, array is not rotated, perform normal binary search
        if (pivot == -1)
            return binarySearch(nums, target, 0, nums.length - 1);
        // if target is greater than start element, it lies on the left ascending part of the array
        else if (target > nums[0])
            return binarySearch(nums, target, 0, pivot);
        // else it is on the right ascending part
        else
            return binarySearch(nums, target, pivot+1, nums.length - 1);
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

            // special condition to check duplicates
            // when start = mid = end
            else if(nums[mid] == nums[start] && nums[mid] == nums[end]) {
                // check if start is pivot
                if(nums[start] > nums[start+1])
                    return start;
                //check if end-1 is pivot
                else if(nums[end] < nums[end-1])
                    return end - 1;

                // else ignore the duplicates
                start++;
                end--;
            }

            // Move to the right side of mid if
            // start is less than mid, which means greater values may lie after mid
            // OR
            // start is equal to mid AND greater than end
            if(nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[start] > nums[end]))
                start = mid;
            else if(nums[mid] < nums[end] || (nums[mid] == nums[end] && nums[mid] < nums[start]))
                end = mid - 1;

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 4, 4, 5, 6, 1, 2, 2, 3, 4};
        int target = 1;

        System.out.println(search(nums, target));
    }
}
