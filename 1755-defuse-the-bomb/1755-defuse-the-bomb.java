class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if(k == 0) return res;

        int start = 1;
        int end = k;
        int windowSum = 0;

        if(k < 0) {
            start = n + k;
            end = n - 1;
        }

        for(int i = start; i<= end; i++) {
            windowSum += code[i];
        }

        for(int i=0; i<n; i++) {
            res[i] = windowSum;
            windowSum -= code[start%n];
            start++;
            end++;
            windowSum += code[end%n];
        }

        return res;
    }
}