package com.aditya.DSA.leetcode;

// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    // optimization: char array in place of string to pass by reference
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        parenthesis(res, new char[n*2], 0, n, n);
        return res;
    }
    public static void parenthesis(List<String> res, char[] S, int pos, int open, int close) {
        if (open == 0 && close == 0) {
            res.add(new String(S));
            return;
        }
        if (open > 0) {
            S[pos] = '(';
            parenthesis(res, S, pos+1, open-1, close);
        }
        if (close > 0 && close > open) {
            S[pos] = ')';
            parenthesis(res, S, pos+1, open, close-1);
        }
    }

    public static void main(String[] args) {
        List<String> paren = new ArrayList<>();
        paren = generateParenthesis(3);
        for (String ele: paren) {
            System.out.println(ele);
        }
    }
}
