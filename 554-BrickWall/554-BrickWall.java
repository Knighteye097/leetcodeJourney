// Last updated: 2/19/2025, 12:27:22 AM
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxGap = 0;

        for(List<Integer> list : wall) {
            int width = 0;
            for(int j=0; j<list.size()-1; j++) {
                width += list.get(j);
                map.put(width, map.getOrDefault(width, 0) + 1);
                maxGap = Math.max(maxGap, map.get(width));
            }
        }

        return wall.size() - maxGap;
    }
}