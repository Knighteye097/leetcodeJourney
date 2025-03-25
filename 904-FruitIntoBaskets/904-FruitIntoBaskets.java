// Last updated: 3/25/2025, 1:17:24 PM
class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, n = fruits.length;
        int[] arr = {-1, -1};
        int maxRes = 0;

        for(int right = 0; right<n; right++) {
            if(arr[0] == -1 || arr[0] == fruits[right]) {
                arr[0] = fruits[right];
            } else if(arr[1] == -1 || arr[1] == fruits[right]){
                arr[1] = fruits[right];
            } else {
                maxRes = Math.max(maxRes, right-left);

                left = right - 1;
                while(left>0 && fruits[left-1] == fruits[left]){
                    left--;
                }

                arr[0] = fruits[left];
                arr[1] = fruits[right];
            }
        }

        return Math.max(maxRes, n-left);
    }
}