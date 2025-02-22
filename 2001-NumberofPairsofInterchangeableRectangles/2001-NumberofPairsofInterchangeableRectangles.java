// Last updated: 2/22/2025, 11:07:24 PM
class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        int n = rectangles.length;
        long res = 0;

        Map<Double, Long> map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            double width = rectangles[i][0];
            double height = rectangles[i][1]; 
        
            double ratio = width/height;

            long count = map.getOrDefault(ratio, 0L);
            res += count;
            map.put(ratio ,count + 1);
        }

        

        return res;
    }
}