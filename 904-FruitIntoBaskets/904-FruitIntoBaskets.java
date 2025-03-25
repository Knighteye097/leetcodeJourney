// Last updated: 3/25/2025, 12:51:07 PM
class Solution {
    public int totalFruit(int[] fruits) {
        int L = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for(int R=0; R<fruits.length; R++) {
            map.put(fruits[R], map.getOrDefault(fruits[R], 0) + 1);

            while(map.size()>2) {
                map.put(fruits[L], map.get(fruits[L]) - 1);
                if(map.get(fruits[L]) == 0) {
                    map.remove(fruits[L]);
                }

                L++;
            }

            res = Math.max(res, R-L+1);
        }

        return res;
    }
}