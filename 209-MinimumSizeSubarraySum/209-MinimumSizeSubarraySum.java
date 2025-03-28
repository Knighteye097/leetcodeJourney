// Last updated: 3/28/2025, 10:38:55 PM
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;

        for(int right=0; right<n; right++){
            sum += nums[right];

            while(sum >= target) {
                res = Math.min(res, (right-left+1));
                sum -= nums[left];
                left++;
            }
        }

        if(res == Integer.MAX_VALUE){
            return 0;
        }

        return res;
    }
}