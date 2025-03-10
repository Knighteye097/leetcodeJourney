class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        char[] arr = colors.toCharArray();
        int itr = 0;
        int res = 0;

        while(itr < n) {
            int idx = itr+1;
            int maxIndex = itr;
            while(idx<n && arr[itr] == arr[idx]) {
                if(neededTime[maxIndex] <= neededTime[idx]) {
                    maxIndex = idx;
                }
                idx++;
            }

            for(int i = itr; i<idx; i++) {
                if(i != maxIndex) {
                    res += neededTime[i];
                }
            }

            itr = idx;
        }

        return res;
    }
}