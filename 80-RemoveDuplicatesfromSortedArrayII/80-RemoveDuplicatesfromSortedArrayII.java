class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        int count = 1;
        int k = 1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1] && count < 2) {
                nums[j] = nums[i];
                j++;
                count++;
                k++;
            } else if(nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                count = 1;
                j++;
                k++;
            }
        }

        return k;
    }
}