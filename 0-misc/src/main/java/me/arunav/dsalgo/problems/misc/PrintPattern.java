package me.arunav.dsalgo.problems.misc;

public class PrintPattern {

    public static void main(String[] args) {
        printDescPattern(15, 0);
        printAscPattern(15, 0, 0);
    }

    private static void printDescPattern(int row, int col) {
        if(row == 0)
            return;
        if(col == row){
            System.out.println(); // Go to next line
            printDescPattern(row - 1, 0);
        } else {
            System.out.print("* ");
            printDescPattern(row, col+1);
        }
    }

    private static void printAscPattern(int total, int row, int col) {
        if(row > total)
            return;
        if(col == row){
            System.out.println(); // Go to next line
            printAscPattern(total, row+1, 0);
        } else {
            System.out.print("* ");
            printAscPattern(total, row, col+1);
        }
    }
}
