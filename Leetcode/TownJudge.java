package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/*
A town has people 1, 2, 3, ..., n.
There is a town judge:
 - who is trusted by all (excluding himself)
 - who trusts no one
 - only one town judge exists
 */


public class TownJudge {

    public static void main(String[] args) {
        int[][] trust = {{1,2},{6,4},{3,2},{2,6},{4,5},{6,1},{1,4},{1,5},{2,3},{2,1},{4,3},{4,2},{2,5},{4,1},{2,4},{6,5},{3,5}};
        int n = 6;

        int TJ = findJudgeFast(n, trust);
        System.out.println(TJ);
    }

    // fast code
    /*
    if person is trusted by someone, increment points
    if person trusts someone, decrement points
    at last person having n-1 points is the town judge
     */
    public static int findJudgeFast(int n, int[][] trust) {
        int[] points = new int[n+1];
        for (int i = 0; i <= n; i++) {
            points[i] = 0;
        }

        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];

            points[a]--;
            points[b]++;
        }
        for (int i = 1; i <= n; i++) {
            if (points[i] == n-1)
                return i;
        }
        return -1;
    }
    // slow code
    public static int findJudge(int n, int[][] trust) {
        if (trust.length == 0) {
            if (n == 1)
                return 1;
            else
                return -1;
        }

        int TJ = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // VALUE No of people trust person KEY
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // create adjacency list
        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            // a trusts b
            adj.get(a).add(b);
            // increment no. of people trusting b
            if (map.containsKey(b)) {
                map.put(b, map.get(b) + 1);
            }
            else {
                map.put(b, 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (adj.get(i).isEmpty()) {
                // if i trusts no one and no candidate for Town Judge
                if (TJ == 0)
                    TJ = i;

                // if multiple candidates for town judge
                else
                    return -1;
            }
        }
        // Town judge is trusted by all (excluding himself)
        if (TJ != 0 && map.get(TJ) == n-1)
            return TJ;

        return -1;
    }
}
