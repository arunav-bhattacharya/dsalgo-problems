package me.arunav.dsalgo.problems.slidingwindow;

/*
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of
 * size ‘k’.
 */

public class _1MaxSumSubarrayOfSizeK {

    public static void main(String[] args) {
        int[] test1 = {2, 1, 5, 1, 3, 2};
        int[] test2 = {2, 3, 4, 1, 5};
        int[] test3 = {1, 12, -5, -6, 50, 3};
        int[] test4 = {0, 1, 1, 3, 3};
//        System.out.println(findMaxSumSubArraySolution1(6, test1));
//        System.out.println(findMaxSumSubArraySolution1(2, test2));
        System.out.println(findMaxSumSubArraySolution1(4, test3));
//        System.out.println(findMaxSumSubArraySolution1(4, test4));

        System.out.println(findMaxSumSubArraySolution2(6, test1));
        System.out.println(findMaxSumSubArraySolution2(2, test2));

    }

    public static int findMaxSumSubArraySolution1(int k, int[] arr) {
        int sum = 0;
        for (int i=0; i<k; i++)
            sum += arr[i];

        int maxSum = sum;
        for(int i=k; i<arr.length; i++){
            sum += arr[i];
            sum -= arr[i-k];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static int findMaxSumSubArraySolution2(int k, int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        // Sliding Window Pattern
        int j = 0;
        maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - arr[j];
                j++;
            }
        }
        return maxSum;
    }
}

