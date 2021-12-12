package me.arunav.dsalgo.problems.recursion._4medium;

public class _2LexicographicalNumbers {

    public static void main(String[] args) {
        int n = 1103;
        printInLexicoOrder(n, 0);
    }

    private static void printInLexicoOrder(int n, int result) {
        if (result > n)
            return;
        if(result != 0)
            System.out.println(result);
        for (int i = 0; i <= 9; i++) {
            if(result == 0 && i == 0)
                continue;
            printInLexicoOrder(n, result * 10 + i);
        }
    }
}
