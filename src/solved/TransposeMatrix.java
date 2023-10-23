
import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}};
        System.out.println(Arrays.deepToString(transposeMatrix(matrix)));
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[][] transposeMatrix = new int[colLen][rowLen];
        for (int rowIndex = 0; rowIndex < rowLen;rowIndex++) {
            for (int colIndex = 0; colIndex < colLen; colIndex++){
                transposeMatrix[colIndex][rowIndex] = matrix[rowIndex][colIndex];
            }
        }
        return transposeMatrix;
    }
}
