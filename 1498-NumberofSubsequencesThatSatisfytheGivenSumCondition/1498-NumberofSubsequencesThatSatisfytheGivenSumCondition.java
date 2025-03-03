// Last updated: 3/3/2025, 11:45:30 PM

//Approach:
//Bruteforce:O(n^2)

//Approach:2 using two pointers
//step:1 sort the array(Sorting helps in efficiently finding the minimum and maximum values.)
//step:2 use two pointers(left, right)as min and max of the subsequence
//      2.1)If nums[left] + nums[right] <= target, count valid subsequences. it means the left and right index satify the given condition so we calculate the no of sebsequences that can form in this range and add to count and do mod. so it means the range satisfies so we move left++ so increase the pointer to find next  subsequence range that satifies the condition.(*****Use Precomputed Powers of 2 to count subsequences efficiently.)
//      2.2) Otherwise, move right inward (right--). ( as sum of num[left]+nums[right]>target) we need to reduce the sum of min and max of subsequence.



class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod=1_000_000_007;
        int n=nums.length;

        // Sort the array for the two-pointer approach
        Arrays.sort(nums);

        int power[]=new int[n];
         power[0]=1;
        // Precompute powers of 2 up to n
         for(int i=1;i<n;i++){
            power[i]=(power[i-1]*2)%mod;   //next no of subseq is = 2^n so 2^previous no of subseq
         }

         int left=0, right=n-1;
         int count=0;

         while(left<=right){
            if(nums[left]+nums[right]<=target){
                count=(count+power[right-left])%mod;   //here directly finding the diff of max and min to find no of subsequence.
                left++; // Expand to include more subsequences
            }else{
                right--; // Reduce max element
            }
         }
       

        return count;
        
    }
}

//tc: nlogn for sorting
 //     n for looping
 // so tc: O(n logn)
 //sc:O(n)     