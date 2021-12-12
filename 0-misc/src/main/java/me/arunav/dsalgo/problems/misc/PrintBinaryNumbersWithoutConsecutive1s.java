package me.arunav.dsalgo.problems.misc;

public class PrintBinaryNumbersWithoutConsecutive1s {

    public static void main(String[] args) {
        int n=3;
        printNumbers(n, "");
    }

    private static void printNumbers(int n, String s) {
        if(n==0) {
            System.out.println(s);
            return;
        }

        printNumbers(n - 1, s + "0");
        if(!s.isEmpty()){
            if(s.charAt(s.length() - 1) == '0')
                printNumbers(n - 1, s + "1");
        } else
            printNumbers(n - 1, s + "1");
    }
}
