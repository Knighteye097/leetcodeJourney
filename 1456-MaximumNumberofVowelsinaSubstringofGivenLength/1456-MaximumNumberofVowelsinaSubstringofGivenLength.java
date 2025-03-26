// Last updated: 3/26/2025, 1:27:03 PM
class Solution {
    public int maxVowels(String s, int k) {
        Predicate<Character> isVowel = ch -> "aeiou".indexOf(ch) != -1; // More concise check
        
        char[] arr = s.toCharArray();
        int res = 0, freq = 0;

        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (isVowel.test(arr[i])) {
                freq++;
            }
        }

        res = freq;

        // Sliding window
        for (int i = k; i < arr.length; i++) {
            if (isVowel.test(arr[i - k])) freq--; // Remove left char
            if (isVowel.test(arr[i])) freq++; // Add right char

            res = Math.max(res, freq);
        }

        return res;
    }
}