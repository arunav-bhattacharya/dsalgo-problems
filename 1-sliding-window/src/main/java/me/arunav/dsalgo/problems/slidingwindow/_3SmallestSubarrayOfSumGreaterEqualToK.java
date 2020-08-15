package me.arunav.dsalgo.problems.slidingwindow;

public class _3SmallestSubarrayOfSumGreaterEqualToK {

    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        System.out.println(findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
    }

    public static int findMinSubArray(int S, int[] arr) {
        int minCount = Integer.MAX_VALUE;
        int sum = 0;
        // Brute Force
        for (int i=0; i< arr.length; i++){
            for (int j=i; j< arr.length; j++){
                sum += arr[j];
                if(sum >= S){
                    minCount = Math.min(minCount, (j-i) + 1);
                    break;
                }
            }
            sum = 0;
        }

        // Sliding Window
        minCount = Integer.MAX_VALUE;
        int j = 0;
        sum = 0;
        for(int i=0; i< arr.length; i++){
            sum += arr[i];
            while(sum >= S){
                minCount = Math.min(minCount, (i-j) + 1);
                sum -= arr[j];
                j++;
            }

        }
        return minCount;
    }
}
