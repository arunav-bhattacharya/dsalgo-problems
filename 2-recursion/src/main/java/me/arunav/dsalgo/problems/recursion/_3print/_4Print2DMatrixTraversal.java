package me.arunav.dsalgo.problems.recursion._3print;

/*
 Given a 2D Matrix of dimension n * m, start traversing from top left to bottom right. You are allowed to go Right or
 Down only. Print all the possible combinations of paths to go from top left to bottom right.
*/

public class _4Print2DMatrixTraversal {

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] matrix = new int[n][m];
        traverse(matrix, 0, 0, "");
    }

    private static void traverse(int[][] matrix, int row, int col, String result) {
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            System.out.println(result);
            return;
        }

        if (row >= matrix.length || col >= matrix[0].length)
            return;

        traverse(matrix, row + 1, col, result.isEmpty() ? "Do" : result + ", Do");
        traverse(matrix, row, col + 1, result.isEmpty() ? "Ri" : result + ", Ri");
        // This is for the variation of the problem when you are allowed to traverse diagonally
        traverse(matrix, row + 1, col + 1, result.isEmpty() ? "Di" : result + ", Di");
    }
}