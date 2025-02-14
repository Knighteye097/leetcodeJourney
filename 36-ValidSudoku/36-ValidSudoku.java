// Last updated: 2/15/2025, 3:05:43 AM
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rowChecker = new int[9][9];
        int[][] colChecker = new int[9][9];
        int[][] boxChecker = new int[9][9];

        int ROWS = board.length, COLS = board[0].length;

        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                char ch = board[i][j];
                if(ch != '.'){
                    int index = ch - '1';
                    int boxIndex = 3*(i/3) + (j/3);

                    if(rowChecker[i][index] == -1 || 
                        colChecker[j][index] == -1 || boxChecker[boxIndex][index] == -1){
                        return false;
                    }

                    rowChecker[i][index] = -1;
                    colChecker[j][index] = -1;
                    boxChecker[boxIndex][index] = -1;

                }
            }
        }

        return true;
    }
}