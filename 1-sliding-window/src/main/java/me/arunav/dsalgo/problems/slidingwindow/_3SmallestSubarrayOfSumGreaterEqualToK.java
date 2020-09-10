package me.arunav.dsalgo.problems.slidingwindow;

public class _3SmallestSubarrayOfSumGreaterEqualToK {

    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        System.out.println(findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
    }

    public static int findMinSubArray(int K, int[] arr) {
        int minCount = Integer.MAX_VALUE;
        int sum = 0;
        // Brute Force
        for (int i=0; i< arr.length; i++){
            for (int j=i; j< arr.length; j++){
                sum += arr[j];
                if(sum >= K){
                    minCount = Math.min(minCount, (j-i) + 1);
                    break;
                }
            }
            sum = 0;
        }

        // Sliding Window
        minCount = Integer.MAX_VALUE;
        int startIdx = 0;
        int endIdx = 0;
        sum = 0;

        for(int element : arr){
            sum += element;
            while(sum >= K){
                minCount = Math.min(minCount, (endIdx-startIdx) + 1);
                sum -= arr[startIdx];
                startIdx++;
            }
            endIdx++;
        }
        return minCount;
    }
}
