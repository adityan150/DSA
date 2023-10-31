package GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class ArrayPairSum {
    public static void main(String[] args) {
        int[] nums = { 6, 14, 12, 14};
        int k = 2;
        System.out.println(canPair(nums, k));
    }
    public static boolean canPair(int[] nums, int k) {
        if (nums.length % 2 != 0)
            return false;
        else if (k == 1 || k == 0)
            return true;

        HashMap<Integer, Integer> rem = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remainder = nums[i] % k;
            rem.put(remainder, rem.getOrDefault(remainder, 0) + 1);
        }

        for (int e: rem.keySet()) {
            int dif = k - e;

            if (e == 0) {
                if (rem.get(e) % 2 != 0)
                    return false;
            }
            else if (rem.containsKey(dif)) {
                if (rem.get(e) != rem.get(dif))
                    return false;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
