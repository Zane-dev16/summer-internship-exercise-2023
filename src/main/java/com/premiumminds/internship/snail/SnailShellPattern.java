package com.premiumminds.internship.snail;

import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * The snail shell pattern is obtained by traversing the matrix in a clockwise spiral,
   * starting from the top-left corner.

   * One lap of the spiral is as follows:
   * - Top row left to right
   * - Right column top to bottom
   * - Bottom row right to left
   * - Left column bottom to top

   * The function adds the values from each lap of the spiral to the result array,
   * continuing repetitively for the interior matrix within the spiral until
   * the interior matrix becomes a 0x0 matrix.
   *
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values that represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {

    if (matrix == null) {
      int[] result = new int[0];
      return CompletableFuture.completedFuture(result);
    }

    int matrixSize = matrix.length;
    int[] result = new int[matrixSize * matrixSize];
  
    int resultIndex = 0;

    int cellRow = 0;
    int cellColumn = 0;

    while (matrixSize > 0) {

      // Top row left to right
      for (int i = 0; i < matrixSize; i++) {
        result[resultIndex++] = matrix[cellRow][cellColumn++];
      }

      cellRow++;
      cellColumn--;

      // Right column top to bottom
      for (int i = 1; i < matrixSize; i++) {
        result[resultIndex++] = matrix[cellRow++][cellColumn];
      }

      cellRow--;
      cellColumn--;

      // Bottom row right to left
      for (int i = 1; i < matrixSize; i++) {
        result[resultIndex++] = matrix[cellRow][cellColumn--];
      }

      cellRow--;
      cellColumn++;

      // Left column bottom to top
      for (int i = 1; i < matrixSize - 1; i++) {
        result[resultIndex++] = matrix[cellRow--][cellColumn];
      }

      cellRow++;
      cellColumn++;
      matrixSize -= 2;
    }

    return CompletableFuture.completedFuture(result);
  };
}
