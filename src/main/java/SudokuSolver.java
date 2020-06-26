/** This class is a simple representation of a sudoku game solver */
public class SudokuSolver {

  /** TABLE_SIZE is the required length and width of the sudoku table */
  private static final int TABLE_SIZE = 9;

  private int[][] actualBoard;

  /**
   * SudokuSolver class constructor
   *
   * @param board - required initial game board
   */
  public SudokuSolver(int[][] board) {
    this.actualBoard = board;
  }

  /**
   * This boolean method checks if the given solution exists in the given row
   *
   * @param row - the row needed to check
   * @param solution - current solution (not the game solution but the cell)
   * @return - boolean
   */
  private boolean findInRow(int row, int solution) {
    for (int i = 0; i < TABLE_SIZE; i++) {
      if (actualBoard[row][i] == solution) {
        return true;
      }
    }
    return false;
  }

  /**
   * This boolean method checks if the given solution exists in the given column
   *
   * @param column - the column needed to check
   * @param solution - current solution
   * @return
   */
  private boolean findInColumn(int column, int solution) {
    for (int i = 0; i < TABLE_SIZE; i++) {
      if (actualBoard[i][column] == solution) {
        return true;
      }
    }
    return false;
  }

  /**
   * This method is checking if the 3x3 square is fulfilling the sudoku puzzle condition
   *
   * @param row - current row
   * @param column - current column
   * @param solution - current solution
   * @return
   */
  private boolean check3Square(int row, int column, int solution) {
    int squareRow = row - row % 3;
    int squareColumn = column - column % 3;

    for (int i = squareRow; i < squareRow + 3; i++) {
      for (int j = squareColumn; j < squareColumn + 3; j++) {
        if (actualBoard[i][j] == solution) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * The magic function which checks if all the sudoku puzzle rules are applied
   *
   * @param row - current row
   * @param column - current column
   * @param solution - current solution
   * @return
   */
  private boolean doesMatch(int row, int column, int solution) {
    return !findInRow(row, solution)
        && !findInColumn(column, solution)
        && !check3Square(row, column, solution);
  }

  public void actualResult() {
    for (int i = 0; i < TABLE_SIZE; i++) {
      for (int j = 0; j < TABLE_SIZE; j++) {
        System.out.print(" " + actualBoard[i][j]);
      }
      System.out.println("\n\r");
    }
  }

  /**
   * This method it is using backtracking algorithm in order to apply the correct solution to the
   * corresponding cell
   *
   * @return - true if the sudoku puzzle it is solved
   */
  public boolean puzzleSolver() {
    for (int i = 0; i < TABLE_SIZE; i++) {
      for (int j = 0; j < TABLE_SIZE; j++) {
        if (actualBoard[i][j] == 0) {
          for (int solution = 1; solution < TABLE_SIZE + 1; solution++) {
            if (doesMatch(i, j, solution)) {
              actualBoard[i][j] = solution;
              if (puzzleSolver()) {
                return true;
              } else {
                actualBoard[i][j] = 0;
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("This is my sudoku solver!");
  }
}
