class Solution {
    public int maxProfit(int[] prices) {
        int maxSoFar = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxSoFar = Math.max(maxSoFar, prices[i] - minPrice);
        }
        return maxSoFar;
    }
}