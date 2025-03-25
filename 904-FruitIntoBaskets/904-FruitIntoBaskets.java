// Last updated: 3/25/2025, 12:55:43 PM
class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, n = fruits.length;

        int[] arr = {-1, -1};

        int maxRes = 0;

        for(; right<n; right++) {
            if(arr[0] == -1) {
                arr[0] = fruits[right];
            } else if(arr[0] != fruits[right] && arr[1] == -1){
                arr[1] = fruits[right];
            } else if(arr[1] != fruits[right] && arr[0] != fruits[right]){
                maxRes = Math.max(maxRes, right-left);
                left = right-1;
                int prevFruit = fruits[left];

                while(left>0 && fruits[left-1] == prevFruit){
                    left--;
                }

                arr[0] = prevFruit;
                arr[1] = fruits[right];
            }
        }

        if(left != right) {
            maxRes = Math.max(maxRes, right-left);
        }


        return maxRes;
    }
}