import java.util.Arrays;
import java.util.Objects;

public class RevealMinesweeper {

    public static void main(String[] args) {
        String[][] board = revealMinesweeper(new String[][]{
                        {"H", "M", "1", "H", "1", "H", "M", "1"},
                        {"H", "H", "H", "H", "M", "H", "2", "H"},
                        {"M", "H", "H", "M", "H", "M", "H", "H"},
                        {"H", "H", "H", "H", "H", "H", "H", "H"},
                        {"1", "M", "H", "H", "H", "H", "M", "H"},
                        {"H", "H", "H", "H", "M", "H", "H", "H"},
                        {"H", "H", "H", "H", "H", "H", "H", "M"}
                },
                6,
                0);

        for (String[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static String[][] revealMinesweeper(String[][] board, int row, int column) {
        return helper(board, row, column, new boolean[board.length][board[0].length]);
    }

    public static String[][] helper(String[][] board, int row, int column, boolean[][] visited) {
        if (visited[row][column]) return board;
        visited[row][column] = true;
        String currentCell = board[row][column];
        if (!currentCell.equals("M") && !currentCell.equals("H")) return board;
        if (currentCell.equals("M")) {
            board[row][column] = "X";
            return board;
        }
        int mineCounter = 0;
        if (row > 0 && Objects.equals(board[row - 1][column], "M")) mineCounter++;
        if (row < board.length - 1 && Objects.equals(board[row + 1][column], "M")) mineCounter++;
        if (column > 0 && Objects.equals(board[row][column - 1], "M")) mineCounter++;
        if (column < board[0].length - 1 && Objects.equals(board[row][column + 1], "M")) mineCounter++;
        if (row > 0 && column > 0 && Objects.equals(board[row - 1][column - 1], "M")) mineCounter++;
        if (row > 0 && column < board[0].length - 1 && Objects.equals(board[row - 1][column + 1], "M")) mineCounter++;
        if (row < board.length - 1 && column > 0 && Objects.equals(board[row + 1][column - 1], "M")) mineCounter++;
        if (row < board.length - 1 && column < board[0].length - 1 && Objects.equals(board[row + 1][column + 1], "M"))
            mineCounter++;

        if (mineCounter == 0) {
            if (row > 0 && Objects.equals(board[row - 1][column], "H")) helper(board, row - 1, column, visited);
            if (row < board.length - 1 && Objects.equals(board[row + 1][column], "H"))
                helper(board, row + 1, column, visited);
            if (column > 0 && Objects.equals(board[row][column - 1], "H")) helper(board, row, column - 1, visited);
            if (column < board[0].length - 1 && Objects.equals(board[row][column + 1], "H"))
                helper(board, row, column + 1, visited);
            if (row > 0 && column > 0 && Objects.equals(board[row - 1][column - 1], "H"))
                helper(board, row - 1, column - 1, visited);
            if (row > 0 && column < board[0].length - 1 && Objects.equals(board[row - 1][column + 1], "H"))
                helper(board, row - 1, column + 1, visited);
            if (row < board.length - 1 && column > 0 && Objects.equals(board[row + 1][column - 1], "H"))
                helper(board, row + 1, column - 1, visited);
            if (row < board.length - 1 && column < board[0].length - 1 && Objects.equals(board[row + 1][column + 1], "H"))
                helper(board, row + 1, column + 1, visited);
        }

        board[row][column] = String.valueOf(mineCounter);
        return board;
    }
}
