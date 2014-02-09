package arrays.allpathsinamatrix;

import numberproblems.factorial.Factorial;

/**
 * Given M * N matrix find count of all distinct paths from top left cell to bottom right. You can only move
 * downwards and to the right from a given cell.
 * Created by techpanja
 * Created on 2/7/14 1:52 PM.
 */
public class AllPathsInAMatrix {

    private AllPathsInAMatrix() {

    }

    /*
    * Count of all paths from top left to bottom right. Can move one position left or right from a given cell.
    * */
    public static int countOfAllPaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        int x = countOfAllPaths(m - 1, n);
        int y = countOfAllPaths(m, n - 1);
        return x + y;
        // int z = countOfAllPaths(m - 1, n - 1)
        // if diagonal moment allowed just add + countOfAllPaths(m - 1, n - 1)
    }

    public static int countOfAllPathsStartFromTopLeft(int m, int n) {
        int i = 0, j = 0;
        return countOfAllPathsFromTopLeft(m, n, i, j);
    }

    private static int countOfAllPathsFromTopLeft(int m, int n, int i, int j) {
        if (i == m || j == n) {
            return 1;
        }
        return countOfAllPathsFromTopLeft(m, n, i + 1, j) + countOfAllPathsFromTopLeft(m, n, i, j + 1);
    }

    public static int numberOfPaths(int m, int n) {
        // Create a 2D table to store results of subproblems
        int count[][] = new int[m][n];

        // Count of paths to reach any cell in first column is 1
        for (int i = 0; i < m; i++)
            count[i][0] = 1;

        // Count of paths to reach any cell in first column is 1
        for (int j = 0; j < n; j++)
            count[0][j] = 1;

        // Calculate count of paths for other cells in bottom-up manner using
        // the recursive solution
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)

                // By uncommenting the last part the code calculatest he total
                // possible paths if the diagonal Movements are allowed
                count[i][j] = count[i-1][j] + count[i][j-1]; //+ count[i-1][j-1];

        }
        return count[m-1][n-1];
    }

    public static long countOfAllPathsFormula(int m, int n) {
        return (Factorial.findFactorial(m + n)) /
                (Factorial.findFactorial(m) * Factorial.findFactorial(n));
    }

    public static void main(String[] args) {
        int numberOfRows = 3;
        int numberOfCols = 3;
        System.out.println(countOfAllPaths(numberOfRows - 1, numberOfCols - 1));
        System.out.println(countOfAllPathsStartFromTopLeft(numberOfRows - 1, numberOfCols - 1));
        System.out.println(numberOfPaths(numberOfRows, numberOfCols));
        System.out.println(countOfAllPathsFormula(numberOfRows - 1, numberOfCols - 1));
        numberOfRows = 4;
        numberOfCols = 4;
        System.out.println(countOfAllPaths(numberOfRows - 1, numberOfCols - 1));
        System.out.println(countOfAllPathsStartFromTopLeft(numberOfRows - 1, numberOfCols - 1));
        System.out.println(numberOfPaths(numberOfRows, numberOfCols));
        System.out.println(countOfAllPathsFormula(numberOfRows - 1, numberOfCols - 1));
    }
}
