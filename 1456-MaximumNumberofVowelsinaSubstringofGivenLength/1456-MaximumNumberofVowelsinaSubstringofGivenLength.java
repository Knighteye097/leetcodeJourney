// Last updated: 3/26/2025, 1:24:49 PM
class Solution {
    public int maxVowels(String s, int k) {
        Predicate<Character> isVowel = ch -> {
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' )
                return true;

            return false;    
        };

        char[] arr = s.toCharArray();
        int n = s.length();

        int res = 0, freq = 0;

        for(int i=0; i<k; i++) {
            if(isVowel.test(arr[i])){
                freq++;
            }
        }

        res = freq;

        for(int i=k; i<n; i++) {
            if(isVowel.test(arr[i-k])) {
                freq--;
            }

            if(isVowel.test(arr[i])) {
                freq++;
            }

            res = Math.max(res, freq);
        }

        return res;
    }
}