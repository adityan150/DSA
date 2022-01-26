package com.aditya.DSA.leetcode;

// https://leetcode.com/problems/zigzag-conversion
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1)
            return s;

        StringBuilder[] strings = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            strings[i] = new StringBuilder("");
        }

        boolean goingUp = true;
        int currentRow = 0;
        for (int i = 0; i < s.length(); i++) {
            // switch direction
            if (i % (numRows - 1) == 0)
                goingUp = !goingUp;
            // concat character to the current row string
            strings[currentRow].append(s.charAt(i));
            if (goingUp)
                currentRow--;
            else
                currentRow++;
        }
        String result = "";
        for (int i = 0; i < numRows; i++)
            result += strings[i];
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "ABCDEFGHI";
        s = convert(s, 4);
        System.out.println(s);
    }
}
