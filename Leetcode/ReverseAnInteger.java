package Leetcode;

public class ReverseAnInteger {
    public static int reverse(int x) {
        boolean positive = true;


        // if x is zero, or single digit
        if (x >= 0 && x < 10) {
            return x;
        }
        // if x is negative
        if (x < 0){
            positive = false;
            x = Math.abs(x);
        }

        int N = (int) Math.log10(x);

        // check 1: reverse number is greater than int range
        if (N == 9 && x%10 > 2)
            return 0;
        int reverse = 0;
        while(N >= 0) {
            N--;
            int temp= reverse*10 + x%10;
            // check 2: reverse number is greater than int range
            if (temp >= reverse)
                reverse = temp;
            else return 0;
            x = x/10;
        }
        if (!positive)
            reverse = -reverse;
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse(120));
    }
}
