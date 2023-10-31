package GeeksForGeeks;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = { 5, 10, -5, 7, -10, 6, -7, -6, -10};
        int N = arr.length;
        System.out.println(maxLen(arr, N));
    }

    static int maxLen(int[] arr, int N)
    {
        int max = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            prefixSum += arr[i];

            if (prefixSum == 0) {
                max = i + 1;
            }
            else {
                if (!map.containsKey(prefixSum)) {
                    map.put(prefixSum, i);
                }
                else {
                    max = Math.max(max, i - map.get(prefixSum));
                }
            }
        }
        return max;
    }
}
