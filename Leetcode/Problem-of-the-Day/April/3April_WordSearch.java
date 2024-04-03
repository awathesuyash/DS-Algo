/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

*/
//Approach 1:
int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
public boolean find(char[][] board, int i, int j, String word, int idx) {
    if (idx == word.length())
        return true;
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '$')
        return false;
    if (board[i][j] != word.charAt(idx)) return false;
    char temp = board[i][j];
    board[i][j] = '$';
    for (int[] dir : directions) {
        int new_i = i + dir[0];
        int new_j = j + dir[1];
        if (find(board, new_i, new_j, word, idx + 1))
            return true;
    }
    board[i][j] = temp;
    return false;
}
public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == word.charAt(0) && find(board, i, j, word, 0))
                return true;
        }
    }
    return false;
}