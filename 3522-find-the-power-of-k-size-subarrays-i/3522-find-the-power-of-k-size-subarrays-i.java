class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] res = new int[nums.length-k + 1];

        for(int i=0; i<=nums.length-k; i++) {
            if(isSeriesOkay(nums, i, i+k-1)) res[i] = nums[i+k-1]; 
            else res[i] = -1;
        }

        return res;
    }

    private boolean isSeriesOkay(int[] nums, int left, int right) {
        for(int i=left+1; i<=right; i++) {
            if(nums[i] - nums[i-1] != 1) {
                return false;
            }
        }

        return true;
    }
}