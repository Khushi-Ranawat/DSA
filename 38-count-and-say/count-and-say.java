class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 0; j < res.length(); j++) {
                if (j + 1 < res.length() && res.charAt(j) == res.charAt(j + 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(res.charAt(j));
                    count = 1;
                }
            }
            res = sb.toString();
        }
        return res;
    }
}