package GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MissingElementsOfARange {
    public static void main(String[] args) {
        int[] arr = { 12, 14, 15, 16, 19, 21, 22, 25};
        int low = 10;
        int high = 20;
        System.out.println(getMissingElements(arr, low, high).toString());
    }

    static ArrayList<Integer> getMissingElements(int[] arr, int low, int high) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0 ; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i = low; i<= high; i++) {
            if (!set.contains(i))
                result.add(i);
        }
        return result;
    }

}
