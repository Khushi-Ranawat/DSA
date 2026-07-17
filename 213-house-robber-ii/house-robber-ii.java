class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
    
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int choice1 = loot(0, n - 2, nums, dp1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int choice2 = loot(1, n - 1, nums, dp2);
        
        return Math.max(choice1, choice2);
    }
    
    private int loot(int i, int end, int[] arr, int[] dp) { 
        if (i > end) return 0;
        if (dp[i] != -1) return dp[i];
        int pick = arr[i] + loot(i + 2, end, arr, dp);
        int skip = loot(i + 1, end, arr, dp); 
        return dp[i] = Math.max(pick, skip);
    }
    
}