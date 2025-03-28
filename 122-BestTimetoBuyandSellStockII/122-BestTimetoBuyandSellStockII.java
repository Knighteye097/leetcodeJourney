class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = Integer.MAX_VALUE;

        for(int price : prices) {
            if(price < buy) {
                buy = price;
            } else {
                maxProfit += price - buy;
                buy = price;
            }
        }

        return maxProfit;
    }
}