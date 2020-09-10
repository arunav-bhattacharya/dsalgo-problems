package me.arunav.dsalgo.problems.slidingwindow;

public class _1MaxSumSubarrayOfSizeK {

    public static void main(String[] args) {
        int[] test1 = new int[]{2, 1, 5, 1, 3, 2};
        int[] test2 = new int[]{2, 3, 4, 1, 5};
        System.out.println(findMaxSumSubArray(3, test1));
        System.out.println(findMaxSumSubArray(2, test2));
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        // Brute-Force technique
        for (int i = 0; i < arr.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
            sum = 0;
        }

        // Sliding Window Pattern
        sum = 0;
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

