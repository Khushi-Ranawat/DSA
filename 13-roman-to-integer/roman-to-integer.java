class Solution {
    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < roman.length; j++) {
                if (s.startsWith(roman[j], i)) {
                    ans += values[j];
                    i += roman[j].length() - 1;
                    break;
                }
            }
        }
        return ans;
    }
}