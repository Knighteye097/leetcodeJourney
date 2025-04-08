// Last updated: 4/8/2025, 10:26:41 PM
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[n-k+1];
        int count = 0;

        for(int i=1; i<k; i++) {
            if(nums[i] - nums[i-1] == 1) count++;
        }

        res[0] = count == k-1 ? nums[k-1] : -1;


        for(int i=1; i<=n-k; i++) {
            if(nums[i] - nums[i-1] == 1) count--;

            if(nums[i+k-1] - nums[i+k-2] == 1) count++;

            res[i] = count == k-1 ? nums[i+k-1] : -1;
        }

        return res;
    }
}