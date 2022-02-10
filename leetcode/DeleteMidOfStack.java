package com.aditya.DSA.leetcode;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/

public class DeleteMidOfStack {
    public static void deleteMidIteration(Stack<Integer> S, int sizeOfStack) {
        Stack<Integer> temp = new Stack<>();
        int mid = (int) Math.ceil(sizeOfStack/2.0);
        int n = sizeOfStack;

        if (n == 0)
            return;
        else if (n == 1) {
            S.pop();
            return;
        }

        while(n != mid) {
            temp.push(S.pop());
            n--;
        }
        S.pop();
        sizeOfStack -=1;
        while(!temp.isEmpty()) {
            S.push(temp.pop());
        }
    }

    public static void deleteMid(Stack<Integer> s, int sizeOfStack) {
        int mid = (int) Math.ceil(sizeOfStack/2.0);
        if (s.size() == mid) {
            s.pop();
            return;
        }
        int temp = s.pop();
        deleteMid(s, sizeOfStack);
        s.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> S1 = new Stack<>();
        Stack<Integer> S2 = new Stack<>();

        int sizeOfStack = 10;
        for (int i = 1; i <= sizeOfStack; i++) {
            S1.push(i);
            S2.push(i);
        }
        deleteMidIteration(S1, sizeOfStack);
        System.out.println(S1);
        deleteMid(S2, sizeOfStack);
        System.out.println(S1);
    }
}
