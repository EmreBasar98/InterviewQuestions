package AlgoExpert.solved;

import java.util.Arrays;

public class RemoveIslands {

    public static int[][] removeIslands(int[][] matrix) {
        boolean[][] nonChangeableIslands = new boolean[matrix.length][matrix[0].length];
        for (int i= 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                boolean onBorder = i == 0 || j == 0 || i == matrix.length - 1 || j == matrix[0].length - 1;
                if (onBorder && matrix[i][j] == 1) {
                    explore(matrix, i, j, nonChangeableIslands);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!nonChangeableIslands[i][j]) matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    public static void explore(int[][] matrix, int i, int j, boolean[][] nonChangeableIslands) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return;
        if (matrix[i][j] == 0) return;
        if (nonChangeableIslands[i][j]) return;
        if(matrix[i][j] == 1) nonChangeableIslands[i][j] = true;
        explore(matrix, i + 1, j, nonChangeableIslands);
        explore(matrix, i - 1, j, nonChangeableIslands);
        explore(matrix, i, j + 1, nonChangeableIslands);
        explore(matrix, i, j - 1, nonChangeableIslands);
    }

    public static void main(String[] args) {
            int[][] matrix = {
                    {1,0,0,0,0,0},
                    {0,1,0,1,1,1},
                    {0,0,1,0,1,0},
                    {1,1,0,0,1,0},
                    {1,0,1,1,0,0},
                    {1,0,0,0,0,1}
            };

        System.out.println(Arrays.deepToString(removeIslands(matrix)));
    }
}
