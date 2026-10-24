class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        if(n == 1) {
            return (double) nums[0];
        }

        double currSum = nums[0];

        for(int i = 1; i < k; i++) {
            currSum += nums[i];
        }

        double maxSum = currSum;

        for(int i = k; i < nums.length; i++) {
            currSum += nums[i] - nums[i - k];
            if(currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum / k;
    }
}