class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal-1);
    }

    private int atMost(int[] nums, int goal) {
        if(goal < 0) return 0;

        int left = 0, right = 0, n = nums.length, sum = 0;

        int res = 0;

        while(right < n) {
            sum += nums[right];

            while(left<n && sum > goal) {
                sum -= nums[left++];
            }

            res += (right-left) + 1;

            right++;
        }

        return res;
    }
}