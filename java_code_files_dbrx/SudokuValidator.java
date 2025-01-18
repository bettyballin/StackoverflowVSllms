import java.lang.String;
import java.lang.Integer;
import java.util.HashSet;
public class SudokuValidator {
    private static final int NO_OF_SUBSQUARES = 3;

    public static boolean isValid(int[][] board) {
        return (isRowsValid(board) && isColumnsValid(board) && isSubgridsValid(board));
    }
    private static boolean isRowsValid(int[][] board){
        for(int i = 0; i < board.length; i++){ // Iterate through all rows
            if(!isValidSet(getRowElementsAsArray(board,i))){
                return false;
            }
        }
        return true;
    }
    private static boolean isColumnsValid(int[][] board){
        for (int i = 0; i < board[0].length; i++){ // Iterate through all columns
            if(!isValidSet(getColumnElementsAsArray(board,i))){
                return false;
            }
        }
        return true;
    }
    private static boolean isSubgridsValid(int[][] board){
      for (int row = 0; row < NO_OF_SUBSQUARES; ++row) { // Iterate through every subgrid (3 by default, but can be changed for a different Sudoku size)
         for (int column = 0; column < NO_OF_SUBSQUARES; ++column){
           if (!isValidSet(getSubGridElementsAsArray(board, row, column))) {
              return false;
           }
        }
      }
      return true;
    }
    private static boolean isValidSet(int[] set) { // Checks if there are any repeating numbers or zeros in the set
       HashSet<Integer> setHS = new HashSet<Integer>();
       for (int i : set){
          if(i == 0 || !setHS.add(i)){ // Duplicate value check OR empty space check: return false
             return false;
         }
      }
      return true;
    }
    private static int[] getRowElementsAsArray(int[][] board, int row) {
        return board[row];
    }
    private static int[] getColumnElementsAsArray(int[][] board, int col) {
        int[] column = new int[board.length]; // Assuming square board
        for (int i = 0; i < board.length; i++) {
            column[i] = board[i][col];
        }
        return column;
    }
    private static int[] getSubGridElementsAsArray(int[][] board, int subGridRow, int subGridCol) {
        int[] subGrid = new int[NO_OF_SUBSQUARES * NO_OF_SUBSQUARES];
        int index = 0;
        int startRow = subGridRow * NO_OF_SUBSQUARES;
        int startCol = subGridCol * NO_OF_SUBSQUARES;
        for (int i = 0; i < NO_OF_SUBSQUARES; i++) {
            for (int j = 0; j < NO_OF_SUBSQUARES; j++) {
                subGrid[index++] = board[startRow + i][startCol + j];
            }
        }
        return subGrid;
    }

    public static void main(String[] args) {
    }
}