class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(board, word, i + 1, j, k + 1, visited) ||
                      dfs(board, word, i - 1, j, k + 1, visited) ||
                      dfs(board, word, i, j + 1, k + 1, visited) ||
                      dfs(board, word, i, j - 1, k + 1, visited);
        visited[i][j] = false;
        return res;
    }
}