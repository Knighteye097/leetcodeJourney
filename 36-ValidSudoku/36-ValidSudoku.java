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
                    int num = ch - '0';
                    int index = num - 1;

                    if(rowChecker[i][index] == -1 || colChecker[j][index] == -1) {
                        return false;
                    } else {
                        rowChecker[i][index] = -1;
                        colChecker[j][index] = -1;
                    }

                    int boxRowIndex = 3*(i/3);
                    boxRowIndex += (j/3);

                    if(boxChecker[boxRowIndex][index] == -1) {
                        // System.out.println("BOX checker failed for the index: row: " + boxRowIndex + " and index: " + index);
                        return false;
                    } else {
                        boxChecker[boxRowIndex][index] = -1;
                    }

                }
            }
        }

        return true;
    }
}