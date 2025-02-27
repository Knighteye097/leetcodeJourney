// Last updated: 2/27/2025, 10:07:54 PM
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n-3; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;

            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;

            for(int j=i+1; j<n-2; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;

                int first = j+1;
                int last = n-1;

                while(first < last) {
                    long sum = (long)nums[i] + nums[j] + nums[first] + nums[last];

                    if(sum == (long)target) {
                        res.add(List.of(nums[i], nums[j], nums[first], nums[last]));

                        while(first < last && nums[first] == nums[first+1]) first++;
                        while(first < last && nums[last] == nums[last-1]) last--;

                        first++;
                        last--;
                    } else if(sum < (long)target) {
                        first++;
                    } else {
                        last--;
                    }
                }
            }
        }

        return res;
    }
}