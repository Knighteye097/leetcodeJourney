class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int firstIdx = 0;
        int secondIdx = 0;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(mid-1>=0 && nums[mid] == nums[mid-1]) {
                firstIdx = mid-1;
                secondIdx = mid;
            } else if(mid+1<n && nums[mid] == nums[mid+1]) {
                firstIdx = mid;
                secondIdx = mid+1;
            } else {
                return nums[mid];
            }

            if(firstIdx % 2 == 0) {
                left = secondIdx + 1;
            } else {
                right = firstIdx - 1;
            }
        }

        return -1;
    }
}