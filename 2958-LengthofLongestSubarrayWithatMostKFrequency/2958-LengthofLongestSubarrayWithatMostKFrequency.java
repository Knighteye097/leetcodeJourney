// Last updated: 4/10/2025, 11:02:23 PM
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for(int right=0; right< nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(left<=right && map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left])-1);
                left++;
            }

            maxLen = Math.max(maxLen, (right-left+1));
        }

        return maxLen;
    }
}