
class Solution {

    public boolean isValidSudoku(char[][] board) {

        if (!checkRows(board)) return false;

        if (!checkColumns(board)) return false;

        if (!checkBoxes(board)) return false;

        return true;
    }

    // Check every row
    public boolean checkRows(char[][] board) {

        for (int i = 0; i < 9; i++) {

            HashSet<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') continue;

                if (set.contains(board[i][j])) {
                    return false;
                }

                set.add(board[i][j]);
            }
        }

        return true;
    }

    // Check every column
    public boolean checkColumns(char[][] board) {

        for (int j = 0; j < 9; j++) {

            HashSet<Character> set = new HashSet<>();

            for (int i = 0; i < 9; i++) {

                if (board[i][j] == '.') continue;

                if (set.contains(board[i][j])) {
                    return false;
                }

                set.add(board[i][j]);
            }
        }

        return true;
    }

    // Check every 3x3 box
    public boolean checkBoxes(char[][] board) {

        for (int row = 0; row < 9; row += 3) {

            for (int col = 0; col < 9; col += 3) {

                HashSet<Character> set = new HashSet<>();

                for (int i = row; i < row + 3; i++) {

                    for (int j = col; j < col + 3; j++) {

                        if (board[i][j] == '.') continue;

                        if (set.contains(board[i][j])) {
                            return false;
                        }

                        set.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }
}