package arrays.fillmatrixwithones;

/**
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true)
 * then make all the cells of ith row and jth column as 1.
 * User: techpanja
 * Date: 2/8/14
 * Time: 6:07 PM
 */
public class FillBinaryMatrixWithOnes {

    private FillBinaryMatrixWithOnes() {

    }

    public static int[][] fillBinaryMatrix(int[][] matrix) {
        int[] rowTemp = new int[matrix.length];
        int[] colTemp = new int[matrix[0].length];
        int noOfRows = rowTemp.length;
        int noOfCols = colTemp.length;
        if (noOfRows == 0 || noOfCols == 0) {
            return new int[][]{};
        }
        for (int i = 0; i < noOfRows; i++) {
            rowTemp[i] = 0;
        }
        for (int i = 0; i < noOfCols; i++) {
            colTemp[i] = 0;
        }
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                if (matrix[i][j] == 1) {
                    rowTemp[i] = 1;
                    colTemp[j] = 1;
                }
            }
        }
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                if (rowTemp[i] == 1 || colTemp[j] == 1) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] inputMatrix) {
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[0].length; j++) {
                System.out.print(inputMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMatrix(fillBinaryMatrix(new int[][]{{1, 0}, {0, 0}, {0, 0}}));
    }
}
