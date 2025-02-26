// Last updated: 2/26/2025, 11:31:04 PM
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for(int i=0; i<n; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            int first = i+1;
            int last = n-1;

            while(first<last) {
                int sum = nums[i] + nums[first] + nums[last];
                if(sum == 0) {
                   res.add(List.of(nums[i], nums[first], nums[last]));

                   while(first<last && nums[first] == nums[first+1]) {
                        first++;
                   }

                   while(first<last && nums[last] == nums[last-1]){
                        last--;
                   }

                   first++;
                   last--;
                } else if(sum > 0){
                    last--;
                } else {
                    first++;
                }
            }
        }

        return res;
    }
}