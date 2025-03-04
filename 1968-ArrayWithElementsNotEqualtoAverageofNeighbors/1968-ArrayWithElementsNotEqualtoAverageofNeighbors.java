class Solution {
    public int[] rearrangeArray(int[] nums) {
       int n = nums.length;
        
        for(int i=0; i<n; i+=2) {
            if(i-1>=0 && nums[i-1] > nums[i]) {
                swap(nums, i, i-1);
            }
            
            if(i+1<n && nums[i+1] > nums[i]) {
                swap(nums, i, i+1);
            }
        }

        return nums;
    }
    
    private void swap(int[] arr, int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}