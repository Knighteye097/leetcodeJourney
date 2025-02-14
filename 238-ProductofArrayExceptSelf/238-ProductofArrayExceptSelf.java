// Last updated: 2/15/2025, 1:01:40 AM
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];

        int product = 1;

        for(int i=0; i<n; i++) {
            product *= nums[i];
            res[i] = product; 
        }

        product = 1;

        for(int i=n-1; i>=0; i--) {
            product *= nums[i];
            nums[i] = product;
        }

        int prefixNum = 0;
        int suffixNum = 0;
        int temp = 0;

        for(int i=0; i<n; i++) {
            if(i==0) {
                prefixNum = 1;
            } else {
                prefixNum = temp;
            }

            if(i==n-1) {
                suffixNum = 1;
            } else {
                suffixNum = nums[i+1];
            }

            temp =  res[i];
            res[i] = suffixNum * prefixNum;
        }

        return res;
    }
}