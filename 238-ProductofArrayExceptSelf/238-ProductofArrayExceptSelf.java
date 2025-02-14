class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int suffix[] = new int[n];
        int prefix[] = new int[n];

        int product = 1;

        for(int i=0; i<n; i++) {
            product *= nums[i];
            prefix[i] = product; 
        }

        product = 1;

        for(int i=n-1; i>=0; i--) {
            product *= nums[i];
            suffix[i] = product;
        }

        int res[] = new int[n];

        int prefixNum = 0;
        int suffixNum = 0;

        for(int i=0; i<n; i++) {
            if(i == 0) {
                prefixNum = 1;
            } else {
                prefixNum = prefix[i-1]; 
            }

            if(i == n-1) {
                suffixNum = 1;
            } else {
                suffixNum = suffix[i+1];
            }

            res[i] = suffixNum * prefixNum;
        }

        return res;
    }
}