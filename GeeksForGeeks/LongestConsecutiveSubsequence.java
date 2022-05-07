package com.aditya.DSA.GeeksForGeeks;

import java.util.HashMap;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {

    }

    static int findLongestConseqSubseq(int[] arr, int N)
    {
        int max = 0;
        // map number vs whether it is start of a consecutive subsequence
        HashMap<Integer, Boolean> map = new HashMap<>();

        // initialize map
        for (int i = 0 ; i < N; i++) {
            map.put(arr[i], true);
        }

        // if number one less than current number is present in the array
        // current number cannot be the start point of the longest consecutive subsequence
        for (int i = 0; i < N; i++) {
            if (map.containsKey(arr[i] - 1))
                map.put(arr[i], false);
        }

        for (int i = 0; i < N; i++) {
            // if current number is a start point of a consecutive subsequence
            if (map.get(arr[i])) {
                int temp = 1;
                // 'temp' no. of consecutive numbers present in array
                while (map.containsKey(arr[i] + temp))
                    temp++;

                max = Math.max(max, temp);
            }
        }
        return max;
    }
}
