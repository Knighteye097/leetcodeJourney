// Last updated: 3/28/2025, 10:40:15 PM
class Solution {
    static{
        for(int i = 0; i < 200; i++){
            minSubArrayLen(9,new int[]{1,2,3,4,5,6});
        }
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0,j=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=target){
                min = Math.min(min,i-j+1);
                sum=sum-nums[j++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}