class Solution {
    public int ladderLength(String beginWord, String endWord, java.util.List<String> wordList) {
        java.util.Set<String> dict = new java.util.HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        java.util.Set<String> beginSet = new java.util.HashSet<>();
        java.util.Set<String> endSet = new java.util.HashSet<>();
        java.util.Set<String> visited = new java.util.HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                java.util.Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            java.util.Set<String> nextLevel = new java.util.HashSet<>();
            for (String word : beginSet) {
                if (endSet.contains(word)) return len;
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (dict.contains(newWord)) {
                            if (endSet.contains(newWord)) return len + 1;
                            if (!visited.contains(newWord)) {
                                visited.add(newWord);
                                nextLevel.add(newWord);
                            }
                        }
                    }
                    chars[i] = original;
                }
            }
            beginSet = nextLevel;
            len++;
        }
        return 0;
    }
}