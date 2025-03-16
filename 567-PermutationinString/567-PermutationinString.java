class Solution {
    public boolean checkInclusion(String s1, String s2) {

        char[] arr_s1 = s1.toCharArray();
        char[] arr_s2 = s2.toCharArray();

        int[] freqArr = new int[26];

        for(char ch : arr_s1) {
            freqArr[ch-'a']++;
        }

        int n = s2.length();

        for(int right = 0; right<n; right++) {
            int index = arr_s2[right]-'a';

            if(freqArr[index]!=0) {
                int start = right;
                int[] tempArr = new int[26];
                while(start<n && freqArr[arr_s2[start]-'a']!=0 && tempArr[arr_s2[start]-'a'] < freqArr[arr_s2[start]-'a']) {
                    tempArr[arr_s2[start]-'a']++;
                    start++;
                }

                if(isArrayEqual(freqArr, tempArr))
                    return true;

            }        
        }

        return false;
    }

    private boolean isArrayEqual(int[] arr1, int[] arr2) {
        for(int i=0; i<26; i++) {
            if(arr1[i] != arr2[i])
                return false;
        }

        return true;
    }
}