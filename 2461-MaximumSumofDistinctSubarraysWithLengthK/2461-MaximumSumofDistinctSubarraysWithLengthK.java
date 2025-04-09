// Last updated: 4/9/2025, 10:45:51 PM
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] freqArr = new int[100001];
        int n = nums.length;
        long maxSum = 0;
        long sum = 0;
        int distinctCount = 0;

        for(int i=0; i<n; i++) {
            if(freqArr[nums[i]] == 0) distinctCount++;
            freqArr[nums[i]]++;
            sum += nums[i];

            if(i>=k) {
                freqArr[nums[i-k]]--;
                if(freqArr[nums[i-k]] == 0) distinctCount--;
                sum-=nums[i-k];
            }

            if(i >= k-1 && distinctCount == k) {
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}