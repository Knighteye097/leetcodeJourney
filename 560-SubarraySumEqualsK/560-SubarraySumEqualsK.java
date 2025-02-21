// Last updated: 2/21/2025, 10:38:14 PM
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int total = 0;
        int res = 0;

        for(int num : nums) {
            total += num;

            int numToFind = total-k;

            if(map.containsKey(numToFind)) {
                res += map.get(numToFind);
            }

            map.put(total, map.getOrDefault(total, 0) + 1);
        }

        return res;
    }
}