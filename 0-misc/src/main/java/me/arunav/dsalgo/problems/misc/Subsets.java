package me.arunav.dsalgo.problems.misc;

public class Subsets {

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 7};
        subsets(arr, 0,"");
    }

    private static void subsets(int[] arr, int i, String result) {
        if(i == arr.length){
            System.out.println(result);
            return;
        }
        subsets(arr, i+1, result);
        subsets(arr, i+1, result + "," + arr[i]);
    }
}

