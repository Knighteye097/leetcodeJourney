// Last updated: 21/03/2025, 23:42:35
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