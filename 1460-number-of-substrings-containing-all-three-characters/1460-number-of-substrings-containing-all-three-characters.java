class Solution {
    public int numberOfSubstrings(String s) {
        int[] freqArr = new int[3];
        char[] arr = s.toCharArray();
        int n = arr.length;

        int right = 0, left = 0, res = 0;

        while(right < n) {
            freqArr[arr[right] - 'a']++;

            while(areCharactersPresent(freqArr)) {
                res += (n-right);
                freqArr[arr[left++] - 'a']--;
            }

            right++;
        }

        return res;
    }

    private boolean areCharactersPresent(int[] freqArr) {
        return (freqArr[0] >= 1 && freqArr[1] >= 1 && freqArr[2] >= 1) ? true : false;
    }
}