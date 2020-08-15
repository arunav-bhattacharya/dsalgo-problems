package me.arunav.dsalgo.problems.slidingwindow;

public class _2MaxAvgSubarrayOfSizeK {

    public static void main(String[] args) {
        int[] test1 = new int[]{2, 1, 5, 1, 3, 2};
        int[] test2 = new int[]{2, 3, 4, 1, 5};
        System.out.println(findMaxAvgSubArray(3, test1));
        System.out.println(findMaxAvgSubArray(2, test2));
    }

    public static double findMaxAvgSubArray(int k, int[] arr) {
        double maxAvg = - 10000.00;
        double sum = 0;
        int j = 0;
        
        // Sliding Window Pattern
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (i >=  k - 1) {
                maxAvg = Math.max(maxAvg, sum/k);
                sum = sum - arr[j];
                j++;
            }
        }
        return maxAvg;
    }
}

