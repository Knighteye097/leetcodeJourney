class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        char[] arr = s.toCharArray();

        int first = 0;
        int res = 0;
        
        for(int itr=0; itr<n; itr++) {
            if(set.contains(arr[itr])){
                res = Math.max(res, itr-first);
                while(arr[first]!=arr[itr]){
                    set.remove(arr[first]);
                    first++;
                }
                first++;
            }
            
            set.add(arr[itr]);
        }

        res = Math.max(res, n-first);

        return res;
    }
}