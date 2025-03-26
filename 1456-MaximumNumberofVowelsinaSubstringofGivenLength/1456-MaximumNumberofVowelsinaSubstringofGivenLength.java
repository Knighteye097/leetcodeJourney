// Last updated: 3/26/2025, 1:25:58 PM
class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int vowelCount = 0, maxVowels = 0;

        // Initial window
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelCount++;
            }
        }

        maxVowels = vowelCount;

        // Sliding window
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k))) {
                vowelCount--;
            }
            if (vowels.contains(s.charAt(i))) {
                vowelCount++;
            }

            maxVowels = Math.max(maxVowels, vowelCount);
        }

        return maxVowels;
    }
}