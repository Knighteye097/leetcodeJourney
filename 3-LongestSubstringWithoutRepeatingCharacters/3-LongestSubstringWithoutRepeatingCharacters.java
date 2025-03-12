// Last updated: 3/12/2025, 10:21:14 PM
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int n = s.length(), first = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>(); 

        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i])){
                first = Math.max(first, map.get(arr[i]) + 1);
            }

            map.put(arr[i], i);
            res = Math.max(res, i-first+1);
        }

        return res;
    }
}