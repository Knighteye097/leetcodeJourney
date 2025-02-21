class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] arr = s.toCharArray();

        int[] firstOccur = new int[26];
        int[] lastOccur = new int[26];

        Arrays.fill(firstOccur, -1);
        Arrays.fill(lastOccur, -1);

        for(int i=0; i<arr.length; i++) {
            int idx = arr[i]-'a';
            if(firstOccur[idx] == -1) {
                firstOccur[idx] = i;
            }

            lastOccur[idx] = i;
        }

        int res = 0;

        for(int i=0; i<26; i++) {
            if(firstOccur[i] != -1 && lastOccur[i] != -1 && firstOccur[i] < lastOccur[i]) {
                Set<Character> tempSet = new HashSet<>();

                for(int j=firstOccur[i]+1; j<lastOccur[i]; j++) {
                    if(!tempSet.contains(arr[j])){
                        res++;
                        tempSet.add(arr[j]);
                    }
                }
            }
        }

        return res;
        
    }
}