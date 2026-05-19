class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, s, 0, new ArrayList<>());
        return ans;
    }
    
    private void backtrack(List<String> ans, String s, int start, List<String> path) {
        if (path.size() == 4 && start == s.length()) {
            ans.add(String.join(".", path));
            return;
        }
        
        if (start == s.length()) return;
        
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) continue;
            String part = s.substring(start, start + i);
            if (isValid(part)) {
                path.add(part);
                backtrack(ans, s, start + i, path);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isValid(String part) {
        if (part.length() > 1 && part.charAt(0) == '0') return false;
        int num = Integer.parseInt(part);
        return num <= 255;
    }
}