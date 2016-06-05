package dynamicprogramming;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int[] largestSum = new int[nums.length];
        int[] runningSum = new int[nums.length];
        //base case
        largestSum[0] = nums[0];
        runningSum[0] = nums[0];
        for (int i=1; i< largestSum.length; i++){
            int max = getMax(largestSum[i-1], runningSum[i-1] +nums[i], nums[i]);
            largestSum[i] = max;
            if (largestSum[i] == largestSum[i-1]){
                int sum = runningSum[i-1] + nums[i];
                if (sum > 0) {
                    runningSum[i] = runningSum[i - 1] + nums[i];
                } else{
                    runningSum[i] = 0;
                }
            } else{
                runningSum[i] = largestSum[i];
            }

        }
        return largestSum[nums.length-1];
    }

    public int getMax(int a, int b, int c){
        if (a >= b && a >=c ){
            return a;
        }
        if (b >=c && b >= a){
            return b;
        }
        return c;
    }
}
