class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private int atMost(int[] nums, int goal) {
        if(goal < 0) return 0;

        int left = 0, right = 0, n = nums.length, noOfOdds = 0, res = 0;


        while(right < n) {
            if((nums[right] & 1) == 1) {
                noOfOdds++;
            }

            while(left<=right && noOfOdds > goal) {
                if((nums[left] & 1) == 1) noOfOdds--;

                left++;
            }

            res += (right-left) + 1;

            right++;
        }

        return res;
    }
}