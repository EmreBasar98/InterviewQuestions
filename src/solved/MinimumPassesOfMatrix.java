import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPassesOfMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {-1, 0, 3},
                {0, -5, -6},

        };
        System.out.println(minimumPassesOfMatrix(matrix));
    }

    public static int minimumPassesOfMatrix(int[][] matrix) {
        List<List<Integer>> queue = new ArrayList<>();
        List<List<Integer>> nextQueue = new ArrayList<>();
        int passes = 0;
        int numOfNeg = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((matrix[i][j] > 0 && !queue.contains(List.of(i, j)))) {
                    queue.add(List.of(i, j));
                }
                if (matrix[i][j] < 0 ) numOfNeg++;
            }
        }
        if (queue.isEmpty()) return -1;
        while(!queue.isEmpty()) {
            List<Integer> index = queue.remove(0);
            int i = index.get(0);
            int j = index.get(1);
            if (i > 0 && matrix[i - 1][j] < 0) {
                matrix[i - 1][j] *= -1;
                nextQueue.add(List.of(i - 1, j));
                numOfNeg--;
            }
            if (i < matrix.length - 1 && matrix[i+1][j] < 0){
                matrix[i + 1][j] *= -1;
                nextQueue.add(List.of(i + 1, j));
                numOfNeg--;
            }
            if (j > 0 && matrix[i][j - 1] < 0) {
                matrix[i][j - 1] *= -1;
                nextQueue.add(List.of(i, j - 1));
                numOfNeg--;
            }
            if (j < matrix[i].length - 1 && matrix[i][j + 1] < 0) {
                matrix[i][j + 1] *= -1;
                nextQueue.add(List.of(i, j + 1));
                numOfNeg--;
            }
            if (queue.isEmpty()) {
                if (nextQueue.isEmpty()) return numOfNeg > 0 ? -1 : passes;
                passes++;
                queue = nextQueue;
                nextQueue = new ArrayList<>();
            }
        }
        return passes;
    }
}
