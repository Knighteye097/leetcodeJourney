// Last updated: 2/24/2025, 10:33:15 PM
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        int count = 1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1] && count < 2) {
                nums[j] = nums[i];
                j++;
                count++;
            } else if(nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                count = 1;
                j++;
            }
        }

        return j;
    }
}