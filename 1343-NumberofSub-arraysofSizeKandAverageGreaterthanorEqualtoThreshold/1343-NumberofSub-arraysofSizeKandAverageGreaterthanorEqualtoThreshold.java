class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int window = 0;
        int res = 0;
        
        for(int i=0; i<k; i++) {
            window += arr[i];
        }

        if(window/k >= threshold) {
            res++;
        }


        
        for(int i=k; i<n; i++) {
            window -= arr[i-k];
            window += arr[i];

            if(window/k >= threshold){
                res++;
            }    
        }

        return res;
    }
}