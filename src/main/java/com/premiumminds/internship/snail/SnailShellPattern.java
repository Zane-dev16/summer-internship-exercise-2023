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
   * The solution is as follows:
   * 
   * Considering that one lap is from the:
   * - top row left to right
   * - right column top to bottom
   * - bottom row right to left
   * - left column bottom to top
   * 
   * The function adds the values of
   * the loop to the result and
   * continue repetitively for the matrix
   * in the interior of the loop
   * 
   * After a certain amount of repetitions
   * the interior of the loop will be
   * a 0x0 matrix or a 1x1 matrix whose element
   * will be added to the result array
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {

    int matrixSize = matrix.length;
  
    int[] result = new int[matrixSize * matrixSize];
    int resultIndex = 0;

    /* position of current cell to add to the result */
    int cellRow = 0;
    int cellColumn = 0;

    while (matrixSize > 1) {

      for (int i = 0; i < matrixSize; i++) {
        result[resultIndex++] = matrix[cellRow][cellColumn++];
      }

      cellRow++;
      cellColumn--;

      for (int i = 1; i < matrixSize; i++) {
        result[resultIndex++] = matrix[cellRow++][cellColumn];
      }

      cellRow--;
      cellColumn--;

      for (int i = 1; i < matrixSize; i++) {
        result[resultIndex++] = matrix[cellRow][cellColumn--];
      }

      cellRow--;
      cellColumn++;

      for (int i = 1; i < matrixSize - 1; i++) {
        result[resultIndex++] = matrix[cellRow--][cellColumn];
      }

      cellRow++;
      cellColumn++;
      matrixSize -= 2;
    }

    if (matrixSize == 1) {
      result[resultIndex] = matrix[cellRow][cellColumn];
    }

    return CompletableFuture.completedFuture(result);
  };
}
