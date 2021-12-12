package me.arunav.dsalgo.problems.recursion._4medium;

import java.util.Arrays;

public class _1BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 13, 2, 1, 7, 92, 12, 4};
        bubbleSort(arr, arr.length, 0);
        Arrays.stream(arr).forEach(i -> System.out.print(i + ","));
    }

    private static void bubbleSort(int[] arr, int length, int i) {
        if(length == 1)
            return;

        if(i == length-1){
            bubbleSort(arr, length-1, 0);
            return;
        }

        if(arr[i] > arr[i+1])
            swap(arr, i, i+1);

        bubbleSort(arr, length, i+1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
