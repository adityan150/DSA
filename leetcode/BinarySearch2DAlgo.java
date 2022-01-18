package com.aditya.DSA.leetcode;

import java.util.Arrays;

public class BinarySearch2DAlgo {
    static int[] search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1;

        while(row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return new int[]{row, col};
            if (matrix[row][col] < target) {
                row++;
            } else {
                col --;
            }
        }
        return new int[] {-1, -1};
    }

    // simple binary search, from start col to end col on a given row
    static int[] binarySearch(int[][] matrix, int row, int colStart, int colEnd, int target) {
        while(colStart <= colEnd) {
            int mid = colStart + (colEnd - colStart) /2;

            if (matrix[row][mid] == target)
                return new int[] {row, mid};

            if (matrix[row][mid] < target) {
                colStart = mid + 1;
            } else {
                colEnd = mid - 1;
            }
        }
        return new int[]{ -1, -1};
    }
    static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;

        if (rows == 0)
            return binarySearch(matrix, 0, 0, cols, target);

        int rowStart = 0;
        int rowEnd = rows;
        final int colMid = cols / 2;

        // search in middle column; get to last two rows
        while (rowStart < rowEnd-1) {
            int rowMid = rowStart + (rowEnd - rowStart)/2;
            // if element is in middle column
            if (matrix[rowMid][colMid] == target)
                return new int[] {rowMid, colMid};
            if (matrix[rowMid][colMid] < target)
                rowStart = rowMid;
            else
                rowEnd = rowMid;
        }
        // rowStart & rowEnd has two last rows
        // now search in 4 parts of the matrix

        // first row, less than middle column element
        if (target < matrix[rowStart][colMid])
            return binarySearch(matrix, rowStart, 0, colMid-1, target);

        // first row, greater than middle column element
        else if (target >= matrix[rowStart][colMid] && target <= matrix[rowStart][cols])
            return binarySearch(matrix, rowStart, colMid, cols, target);

        // second row, less than middle column element
        else if (target < matrix[rowEnd][colMid])
            return binarySearch(matrix, rowEnd, 0, colMid-1, target);

        // second row, greater than middle column element
        else
            return binarySearch(matrix, rowEnd, colMid, cols, target);
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {13, 23, 33, 43},
                {25, 35, 45, 55},
                {28, 38, 48, 58}
        };
        int target = 38;

        int[][] sortedMatrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        System.out.println(Arrays.toString(search(matrix, target)));
        System.out.println(Arrays.toString(searchInSortedMatrix(sortedMatrix, 3)));
    }
}
