
class Solution {
    public String getPermutation(int n, int k) {
        if (n == 1) return "1";
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact[i];
            k %= fact[i];
            sb.append(nums[index]);
            nums = remove(nums, index);
        }
        return sb.toString();
    }

    private int[] remove(int[] nums, int index) {
        int[] result = new int[nums.length - 1];
        System.arraycopy(nums, 0, result, 0, index);
        System.arraycopy(nums, index + 1, result, index, nums.length - index - 1);
        return result;
    }
}
