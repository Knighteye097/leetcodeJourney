// Last updated: 2/14/2025, 11:48:40 PM
class NumMatrix {

    int[][] prefixSumMat;

    public NumMatrix(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        this.prefixSumMat = new int[ROWS+1][COLS+1];

        for(int i=1; i<=ROWS; i++) {
            for(int j=1; j<=COLS; j++) {
                this.prefixSumMat[i][j] = matrix[i-1][j-1]
                                            + this.prefixSumMat[i-1][j]
                                            + this.prefixSumMat[i][j-1]
                                            - this.prefixSumMat[i-1][j-1]; 
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return this.prefixSumMat[row2+1][col2+1]
                - this.prefixSumMat[row2+1][col1]
                - this.prefixSumMat[row1][col2+1]
                + this.prefixSumMat[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */