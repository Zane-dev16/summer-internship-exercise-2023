package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  };

  @Test
  public void snailShellPatternTestNullMatrix() throws InterruptedException, ExecutionException, TimeoutException {
      int[][] matrix = null;
      Future<int[]> resultFuture = new SnailShellPattern().getSnailShell(matrix);
      int[] result = resultFuture.get(10, TimeUnit.SECONDS);
      int[] expected = {};
      assertArrayEquals(expected, result);
  }

  @Test
  public void snailShellPatternTestEmptyMatrix() throws InterruptedException, ExecutionException, TimeoutException {
      int[][] matrix = {};
      Future<int[]> resultFuture = new SnailShellPattern().getSnailShell(matrix);
      int[] result = resultFuture.get(10, TimeUnit.SECONDS);
      int[] expected = {};
      assertArrayEquals(expected, result);
  }

  @Test
  public void snailShellPatternTestSingleElementMatrix() throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {{9}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {9};
    assertArrayEquals(result, expected);
  }

  @Test
  public void snailShellPatternTest2x2Matrix() throws InterruptedException, ExecutionException, TimeoutException {
      int[][] matrix = { 
          { 1, 2 },
          { 4, 3 }
      };
      Future<int[]> resultFuture = new SnailShellPattern().getSnailShell(matrix);
      int[] result = resultFuture.get(10, TimeUnit.SECONDS);
      int[] expected = { 1, 2, 3, 4 };
      assertArrayEquals(expected, result);
  }

  @Test
  public void snailShellPatternTest3x3Matrix()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void snailShellPatternTest4x4Matrix() throws InterruptedException, ExecutionException, TimeoutException {
      int[][] matrix = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
      Future<int[]> resultFuture = new SnailShellPattern().getSnailShell(matrix);
      int[] result = resultFuture.get(10, TimeUnit.SECONDS);
      int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
      assertArrayEquals(expected, result);
  }

  @Test
  public void snailShellPatternTest5x5Matrix() throws InterruptedException, ExecutionException, TimeoutException {
      int[][] matrix = { 
          { 1, 2, 3, 4, 5 },
          { 16, 17, 18, 19, 6 },
          { 15, 24, 25, 20, 7 },
          { 14, 23, 22, 21, 8 },
          { 13, 12, 11, 10, 9 }
      };
      Future<int[]> resultFuture = new SnailShellPattern().getSnailShell(matrix);
      int[] result = resultFuture.get(10, TimeUnit.SECONDS);
      int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
      assertArrayEquals(expected, result);
  }

  @Test
  public void snailShellPatternTest6x6Matrix() throws InterruptedException, ExecutionException, TimeoutException {
      int[][] matrix = { 
          { 1, 2, 3, 4, 5, 6 },
          { 20, 21, 22, 23, 24, 7 },
          { 19, 32, 33, 34, 25, 8 },
          { 18, 31, 36, 35, 26, 9 },
          { 17, 30, 29, 28, 27, 10 },
          { 16, 15, 14, 13, 12, 11 }
      };
      Future<int[]> resultFuture = new SnailShellPattern().getSnailShell(matrix);
      int[] result = resultFuture.get(10, TimeUnit.SECONDS);
      int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36 };
      assertArrayEquals(expected, result);
  }

  @Test
  public void snailShellPatternTestCustomOrder1() throws InterruptedException, ExecutionException, TimeoutException {
      int[][] matrix = { 
          { 1, 8, 7 },
          { 2, 9, 6 },
          { 3, 4, 5 }
      };
      Future<int[]> resultFuture = new SnailShellPattern().getSnailShell(matrix);
      int[] result = resultFuture.get(10, TimeUnit.SECONDS);
      int[] expected = { 1, 8, 7, 6, 5, 4, 3, 2, 9 };
      assertArrayEquals(expected, result);
  }

  @Test
  public void snailShellPatternTestCustomOrder2() throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {
      {5, 8, 3, 6},
      {2, 4, 7, 9},
      {1, 0, 1, 2},
      {3, 6, 4, 5}
    };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {5, 8, 3, 6, 9, 2, 5, 4, 6, 3, 1, 2, 4, 7, 1, 0};
    assertArrayEquals(result, expected);
  }
}