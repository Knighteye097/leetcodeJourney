// Last updated: 3/20/2025, 1:37:09 AM
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length, window = 0, res = 0;
        
        for(int i=0; i<k; i++) {
            window += arr[i];
        }

        if(window >= k * threshold) res++;


        
        for(int i=k; i<n; i++) {
            window = window + arr[i] - arr[i-k];

            if(window >= k * threshold) res++;   
        }

        return res;
    }
}