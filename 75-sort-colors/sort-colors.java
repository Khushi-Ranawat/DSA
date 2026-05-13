class Solution {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1, cur = 0;
        while (cur <= high) {
            if (nums[cur] == 0) {
                swap(nums, low, cur);
                low++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, high);
                high--;
            } else {
                cur++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}