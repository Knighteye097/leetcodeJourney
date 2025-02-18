class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        if(nums.length == 0) {
            return 0;
        }

        int res = 0;
        int curr = 1;
        int prev = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(nums[i] == prev+1) {
                curr++;
            } else if (nums[i] == prev) {
                
            } else {
                res = Math.max(curr, res);
                curr = 1;
            }
            prev = nums[i];
        }

        res = Math.max(curr, res);

        return res;   
    }
}