class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        int n = arr1.length;


        int[] cost = new int[n];

        for(int i=0; i<n; i++) {
            cost[i] = Math.abs(arr1[i]-arr2[i]);
        }

        int sum = 0;
        int res = 0;
        int left = 0;

        for(int right=0; right<n; right++){
            sum += cost[right];

            while(sum > maxCost) {
                sum -= cost[left];
                left++;
            }

            if(sum <= maxCost) {
                res = Math.max(res, ((right-left)+1));
            }
        }

        return res;
    }
}