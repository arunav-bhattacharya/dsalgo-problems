package me.arunav.dsalgo.problems.recursion._3print;

public class _5NoOfWaysToJumpNCells {
    public static void main(String[] args) {
        int nCells = 5;
        jump(nCells, 1, "");
    }

    private static void jump(int n, int i, String result) {
        if(i == n){
            System.out.println(result);
            return;
        }

        if(i > n)
            return;

        for(int j=1; j <= 6; j++){
            jump(n, i + j, result.isEmpty() ? j + "" : result + ", " + j);
        }
    }
}