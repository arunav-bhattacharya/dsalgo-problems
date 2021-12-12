package me.arunav.dsalgo.problems.dp;

/*
Given an N * M matrix with some blocked cells, find out the number of ways in which one can travel from top left corner
of the matrix to the bottom right. The directions in which you can move are Down and Right only, and you can't travel
over a blocked cell.
*/

/*

The intuition to solve this problem is we try to build a dp array for each cell. At the end of the exploration the
starting cell should have all the paths to end of matrix.

Recursive intuition is to find the no. of ways we can reach till the end of the matrix from right of current cell and
bottom of current cell and then add those 2 ways and store in the current cell.

f(row, col) = f(row + 1, col) + f(row, col + 1)

*/

public class NoOfWaysToTraverseAMatrixWithBlockedCells {

    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int[][] matrix = new int[n][m];
        matrix[3][3] = 1;
        boolean[][] isVisited = new boolean[n][m];
        int[][] dp = new int[n][m];
        explore(matrix, 0, 0, isVisited, dp);
        System.out.println(dp[0][0]);
    }

    private static int explore(int[][] matrix, int row, int col, boolean[][] isVisited, int[][] dp) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Base condition - when travelled till end of matrix
        if(row == n-1 && col == m-1) {
            dp[row][col] = 1;
            return 1;
        }

        // If already found a path, then return the no. of ways you can reach end of matrix from that point
        if(dp[row][col] != 0)
            return dp[row][col];

        // Explore the next row
        int totCount = 0;
        if(isSafe(matrix, row+1, col)) {
            isVisited[row+1][col] = true;
            int count = explore(matrix, row + 1, col, isVisited, dp);
            isVisited[row+1][col] = false;
            totCount += count;
        }

        // Explore the next col
        if(isSafe(matrix, row, col+1)) {
            isVisited[row][col+1] = true;
            int count = explore(matrix, row, col+1, isVisited, dp);
            isVisited[row][col+1] = false;
            totCount += count;
        }

        // Update the dp array
        dp[row][col] = totCount;
        return totCount;
    }

    private static boolean isSafe(int[][] matrix, int row, int col) {
        return row < matrix.length && col < matrix[0].length && matrix[row][col] == 0;
    }
}
