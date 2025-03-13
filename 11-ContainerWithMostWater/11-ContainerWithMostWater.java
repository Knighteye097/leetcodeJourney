// Last updated: 13/03/2025, 23:26:43
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int n = height.length;

        int first = 0;
        int last = n-1;

        while(first < last) {
            int currHeight = Math.min(height[first], height[last]);
            int currLength = (last-first);
            int currArea = currLength * currHeight;

            maxArea = Math.max(maxArea, currArea);

            while(first<last && height[first] <= currHeight) {
                first++;
            }

            while(first<last && height[last] <= currHeight) {
                last--;
            }
        }

        return maxArea;
    }
}