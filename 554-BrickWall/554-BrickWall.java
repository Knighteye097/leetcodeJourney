class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();

        Map<Integer, Integer> map = new HashMap<>();

        int width = 0;

        for(int i=0; i<n; i++) {
            width = 0;
            for(int j=0; j<wall.get(i).size()-1; j++) {
                width += wall.get(i).get(j);
                map.put(width, map.getOrDefault(width, 0) + 1);
            }
        }

        int maxGap = 0;
        

        for(int gap : map.values()) {
            maxGap = Math.max(maxGap, gap);
        }

        return n - maxGap;
    }
}