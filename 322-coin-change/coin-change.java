class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[n][amount+1];
        int ans =helper(0,amount,coins,dp);
        return (ans!=Integer.MAX_VALUE) ? ans:-1;
        
    }
    private static int helper(int i,int amount,int[]coins,int[][] dp){
        if(i==coins.length) {
            if (amount==0) return 0;
            else return Integer.MAX_VALUE;
        }     
        if(dp[i][amount]!=0) return dp[i][amount];
        int skip =helper(i+1,amount,coins,dp);
        if (amount<coins[i] ) return dp[i][amount]=skip;
        int take = helper(i,amount-coins[i],coins,dp);
        int pick=take==(Integer.MAX_VALUE)? take:take+1;
        return dp[i][amount] =Math.min(pick,skip);
    }
}