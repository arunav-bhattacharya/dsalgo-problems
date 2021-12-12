package me.arunav.dsalgo.problems.dp;

import java.util.Scanner;

public class PrintLCS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take both strings as input
        // Sample input:
        // afhjasfjdb adhajfhjasafja
        System.out.println("Enter the 2 Strings... \n");
        String s1 = sc.next();
        String s2 = sc.next();

        Solution obj = new Solution(s1, s2);
        System.out.println("\nLCS:" + obj.lcs());
    }
}

class Solution {

    int[][] dpCache;
    int l1 = 0;
    int l2 = 0;
    String s1;
    String s2;

    Solution(String s1, String s2) {
        this.l1 = s1.length();
        this.l2 = s2.length();
        this.s1 = s1;
        this.s2 = s2;
        dpCache = new int[l1 + 1][l2 + 1];
    }

    public String lcs() {
        // Populate the dpCache (which also returns calculates the length of longest common subsequence)
        int length = lcs(s1, s2, l1, l2, dpCache);
        System.out.println("\nLength of LCS:" + length);

        // Printing the DP Cache
        printDPCache();

        // Code for printing LCS
        StringBuilder lcs = new StringBuilder();
        for (int i = l1, j = l2; i > 0 && j > 0; ) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                // Return the max of left & top of current i,j
                if (dpCache[i - 1][j] > dpCache[i][j - 1])
                    i--;
                else
                    j--;
            }
        }
        return lcs.reverse().toString();
    }

    private int lcs(String s1, String s2, int i, int j, int[][] dpCache) {
        if (i == 0 || j == 0)
            return 0;

        if (dpCache[i][j] == 0) {
            dpCache[i][j] =
                    (s1.charAt(i - 1) == s2.charAt(j - 1)) ?
                            1 + lcs(s1, s2, i - 1, j - 1, dpCache) :
                            Math.max(lcs(s1, s2, i - 1, j, dpCache), lcs(s1, s2, i, j - 1, dpCache));
        }
        return dpCache[i][j];
    }

    private void printDPCache() {
        System.out.println("\nDP Matrix:");
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++)
                System.out.print(dpCache[i][j] + " ");
            System.out.println();
        }
    }
}