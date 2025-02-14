class NumMatrix {
    int[][] prefixSumMatrix;

    public NumMatrix(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        this.prefixSumMatrix = new int[ROWS][COLS];
        int prefixSum = 0;
        int upperSum = 0;

        for(int i=0; i<ROWS; i++) {
            prefixSum = 0;
            upperSum = 0;
            for(int j=0; j<COLS; j++) {
                prefixSum += matrix[i][j];
                if(i-1>=0){
                    upperSum = prefixSumMatrix[i-1][j];
                }

                prefixSumMatrix[i][j] = prefixSum + upperSum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        if(row1-1>=0 && col1-1>=0) {
            res += prefixSumMatrix[row1-1][col1-1];
        }

        res += prefixSumMatrix[row2][col2];
        
        if(col1-1>=0) {
            res -= prefixSumMatrix[row2][col1-1];
        }

        if(row1-1 >= 0) {
            res -= prefixSumMatrix[row1-1][col2];
        }

        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */