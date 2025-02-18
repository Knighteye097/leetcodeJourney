// Last updated: 2/18/2025, 10:49:45 PM
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int res = 0;

        for(int num : nums) {
            if(!set.contains(num-1)) {
                int prev = num;
                int curr = 1;

                while(set.remove(prev+1)) {
                    prev++;
                    curr++;
                }

                res = Math.max(curr, res);
            }
        }
 
        return res;
    }
}