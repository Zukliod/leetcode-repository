import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // row + col
        boolean[] diag2 = new boolean[2 * n - 1]; // (n - 1) + row - col

        backtrack(0, board, res, n, cols, diag1, diag2);
        return res;
    }

    private void backtrack(int row, char[][] board, List<List<String>> res, int n,
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            res.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = (n - 1) + row - col;

            // O(1) conflict check
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // Place queen and mark paths
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1, board, res, n, cols, diag1, diag2);

            // Backtrack
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}