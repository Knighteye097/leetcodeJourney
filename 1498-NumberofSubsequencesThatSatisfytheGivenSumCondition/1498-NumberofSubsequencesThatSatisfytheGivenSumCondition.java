// Last updated: 14/03/2025, 22:31:40
class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int modulo = 1_000_000_007;

        int[] power = new int[n];
        power[0] = 1;

        for(int i=1; i<n; i++) {
            power[i] = (2*power[i-1])%modulo;
        }

        int first = 0;
        int last = n - 1;
        int count = 0;

        while(first <= last) {
            if(nums[first] + nums[last]<=target){
                count = (count + power[last-first])%modulo;
                first++;
            } else {
                last--;
            }
        }

        return count;
    }
}