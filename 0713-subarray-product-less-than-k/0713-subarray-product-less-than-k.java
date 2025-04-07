class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0, n = nums.length, res = 0;

        long product = 1;

        while(right < n) {
            product *= nums[right];

            while(product >= k && left <= right) {
                product /= nums[left];

                left++;
            }

            res += (right-left) + 1;

            right++;
        }

        return res;
    }
}