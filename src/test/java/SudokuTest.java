import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SudokuTest {

  /** The given sudoku puzzles */
  public static final int[][] EASY_SUDOKU = {
    {0, 1, 3, 8, 0, 0, 4, 0, 5},
    {0, 2, 4, 6, 0, 5, 0, 0, 0},
    {0, 8, 7, 0, 0, 0, 9, 3, 0},
    {4, 9, 0, 3, 0, 6, 0, 0, 0},
    {0, 0, 1, 0, 0, 0, 5, 0, 0},
    {0, 0, 0, 7, 0, 1, 0, 9, 3},
    {0, 6, 9, 0, 0, 0, 7, 4, 0},
    {0, 0, 0, 2, 0, 7, 6, 8, 0},
    {1, 0, 2, 0, 0, 8, 3, 5, 0},
  };

  public static final int[][] HARD_SUDOKU = {
    {0, 0, 2, 0, 0, 0, 0, 4, 1},
    {0, 0, 0, 0, 8, 2, 0, 7, 0},
    {0, 0, 0, 0, 4, 0, 0, 0, 9},
    {2, 0, 0, 0, 7, 9, 3, 0, 0},
    {0, 1, 0, 0, 0, 0, 0, 8, 0},
    {0, 0, 6, 8, 1, 0, 0, 0, 4},
    {1, 0, 0, 0, 9, 0, 0, 0, 0},
    {0, 6, 0, 4, 3, 0, 0, 0, 0},
    {8, 5, 0, 0, 0, 0, 4, 0, 0},
  };

  /**
   * This test verifies if the sudoku game is completed correct and prints the result in the console
   */
  @Test
  public void testSudoku() {
    final SudokuSolver solver = new SudokuSolver(EASY_SUDOKU);
    final SudokuSolver solver2 = new SudokuSolver(HARD_SUDOKU);
    assertTrue(solver.puzzleSolver());
    assertTrue(solver2.puzzleSolver());
    solver.actualResult();
    solver2.actualResult();
  }
}
