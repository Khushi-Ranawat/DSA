class Solution {
     public int minCostClimbingStairs(int[] arr) {
        int n =arr.length;
        int[] dp = new int[n];
        dp[0]=arr[0];
        dp[1]=arr[1];
        for(int i =2;i<n;i++){
            dp[i] = arr[i]+Math.min(dp[i-2],dp[i-1]);
        }
        return Math.min(dp[n-2],dp[n-1]);
    }    
    // static int[] dp;
    // public int minCostClimbingStairs(int[] cost) {
    //     int n =cost.length;
    //     dp = new int[n];
    //     Arrays.fill(dp,-1);
    //     return Math.min(minCost(0,cost),minCost(1,cost));
    // }
    // private static int minCost(int i,int[] cost){
    //     if(i>=cost.length) return 0;
    //     if(dp[i]!=-1) return dp[i];
    //     return dp[i] =cost[i] +Math.min(minCost(i + 1,cost),minCost(i+2,cost));
    // }
}