class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        Integer modulo = 1_000_000_007;

        Integer[] power = new Integer[nums.length];
        power[0] = 1;

        for(int i=1; i<nums.length; i++) {
            power[i] = (2*power[i-1])%modulo;
        }

        int first = 0;
        int last = nums.length - 1;
        int count = 0;

        while(first <= last) {
            int sum = nums[first] + nums[last];

            if(sum<=target){
                count = (count + power[last-first])%modulo;
                first++;
            } else {
                last--;
            }
        }

        return count;
    }
}