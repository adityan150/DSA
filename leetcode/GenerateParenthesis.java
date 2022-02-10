package com.aditya.DSA.leetcode;

// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        parenthesis(res, "", n, n);
        return res;
    }
    public static void parenthesis(List<String> res, String S, int open, int close) {
        if (open == 0 && close == 0) {
            res.add(S);
            return;
        }
        if (open > 0) {
            S += "(";
            parenthesis(res, S, open-1, close);
            S = S.substring(0, S.length()-1);
        }
        if (close > 0 && close > open) {
            S += ")";
            parenthesis(res, S, open, close-1);
            S = S.substring(0, S.length()-1);
        }
    }

    public static void main(String[] args) {
        List<String> paren = new ArrayList<>();
        paren = generateParenthesis(8);
        for (String ele: paren) {
            System.out.println(ele);
        }
    }
}
