class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n-3; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;

            for(int j=i+1; j<n-2; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;

                int first = j+1;
                int last = n-1;

                while(first < last) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[first] + (long)nums[last];

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