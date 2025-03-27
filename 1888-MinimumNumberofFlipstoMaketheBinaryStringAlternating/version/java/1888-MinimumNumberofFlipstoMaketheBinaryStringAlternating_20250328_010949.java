// Last updated: 28/03/2025, 01:09:49
class Solution {
    public int minFlips(String s) {
        int windowSize = s.length();
        int n = 2*windowSize;
        s = s+s;

        char[] inputArray = s.toCharArray();

        int diff1 = 0;
        int diff2 = 0;
        int res = Integer.MAX_VALUE;
        char first = '1';
        char second = '0';

        for(int i=0; i<n; i++) {
            first = (i%2==0) ?  '1' : '0';
            second = (i%2==0) ? '0' : '1';

            if(inputArray[i] != first) diff1++;
            if(inputArray[i] != second) diff2++;

            if(i >= windowSize) {

                first = ((i-windowSize)%2==0) ? '1' : '0';
                second = ((i-windowSize)%2==0) ? '0' : '1';

                if(inputArray[i-windowSize] != first) diff1--;
                if(inputArray[i-windowSize] != second) diff2--;
            }

            if(i >= windowSize-1) {
                res = Math.min(res,Math.min(diff1, diff2));
            }
        }

        return res;
    }
}