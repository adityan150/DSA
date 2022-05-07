package com.aditya.DSA.GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctElementsInEveryWindow {
    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 4, 1, 4, 2, 3};
        int n = A.length;
        int k = 4;
        System.out.println(countDistinct(A, n, k).toString());
    }

    static ArrayList<Integer> countDistinct2(int[] A, int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // map each element of array with its frequency in current window
        // No. of keys in map = no. of unique elements in the window

        // Map the first window
        for (int i = 0; i < k; i++) {
            int e = A[i];  // element
            map.putIfAbsent(e, 0);
            map.put(e, map.get(e)+1);
        }
        // add no. of unique elements in the map
        result.add(map.size());

        for (int i = k; i < n; i++) {
            int eOld = A[i-k]; // first element of last window

            if (map.get(eOld) == 1) {
                // if frequency is 1, remove from map
                map.remove(eOld);
            }
            else{
                // else decrement frequency by 1
                map.put(eOld, map.get(eOld)-1);
            }

            int e = A[i];  // element
            map.putIfAbsent(e, 0);
            map.put(e, map.get(e)+1);

            // add no. of unique elements in current window in result
            result.add(map.size());
        }
        return result;
    }

    static ArrayList<Integer> countDistinct(int[] A, int n, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = k-1; i < n; i++) {
            for (int j = i - (k-1); j <= i; j++) {
                map.put(A[j], j);
            }
            result.add(map.size());
            map.clear();
        }
        return result;
    }
}
