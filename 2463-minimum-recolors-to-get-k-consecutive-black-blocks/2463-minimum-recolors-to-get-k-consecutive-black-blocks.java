class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] arr = blocks.toCharArray();

        int left = 0, right = 0, n = arr.length;
        int res = Integer.MAX_VALUE;
        int operation = 0;

        while(right < n) {
            if(arr[right] == 'W') {
                operation++;
            }

            while(left <= right && right-left+1 > k) {
                if(arr[left] == 'W') operation--;

                left++;
            }

            if((right-left+1) == k) {
                res = Math.min(res, operation);
            }

            right++;
        }

        return res;
    }
}