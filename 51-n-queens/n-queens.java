public class Solution {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0)
            return result;

        List<String> board = new ArrayList<>();
       
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append('.');
            }
            board.add(row.toString());
        }

        int startRow = 0;
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> diags = new HashSet<>();
        HashSet<Integer> antiDiags = new HashSet<>();
        solve(board, startRow, cols, diags, antiDiags);

        return result;
    }

    private void solve(List<String> board, int row, HashSet<Integer> cols, HashSet<Integer> diagR, HashSet<Integer> diagL) {
        if (row == board.size()) {
            result.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            int diagLId = row - col;
            int diagRId = row + col;

            if (cols.contains(col) || diagR.contains(diagRId) || diagL.contains(diagLId))
                continue;

            cols.add(col);
            diagR.add(diagRId);
            diagL.add(diagLId);
            StringBuilder newRow = new StringBuilder(board.get(row));
            newRow.setCharAt(col, 'Q');
            board.set(row, newRow.toString());

            solve(board, row + 1, cols, diagR, diagL);

            cols.remove(col);
            diagR.remove(diagRId);
            diagL.remove(diagLId);
            newRow.setCharAt(col, '.');
            board.set(row, newRow.toString());
        }
    }
}