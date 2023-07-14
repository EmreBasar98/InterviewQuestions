import java.util.ArrayList;
import java.util.List;

public class RiverSizes {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        System.out.println(riverSizes(grid));
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        List<String> visited = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !visited.contains(i + "," + j)) {
                    sizes.add(explore(i, j, visited, matrix));

                }
            }
        }
        return sizes;
    }

    public static int explore(int i, int j, List<String> visited, int[][] matrix) {
        if (i < 0 || i > matrix.length - 1) return 0;
        if (j < 0 || j > matrix[0].length - 1) return 0;
        if (matrix[i][j] == 0) return 0;
        if (visited.contains(i + "," + j)) return 0;
        visited.add(i + "," + j);

        int size = 1;
        size += explore(i, j + 1, visited, matrix);
        size += explore(i, j - 1, visited, matrix);
        size += explore(i + 1, j, visited, matrix);
        size += explore(i - 1, j, visited, matrix);
        return size;
    }
}
