package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] arr = {
                {2, 5},
                {8, 4},
                {0, -1}
        };
        System.out.println(spiralTraverse2(arr));

    }

    public static List<Integer> spiralTraverse2(int[][] array) {
        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;
        int maxCount = array[0].length * array.length;
        int rowBound = array.length;
        int colBound = array[0].length;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] len = {colBound, rowBound, colBound , rowBound};
        int[] current = {0, 0};
        int lenIter = 0;
        int dirIter = 0;

        while (count < maxCount - 1) {
            for (int i = 0; i < len[lenIter] - 1; i++) {
                res.add(array[current[0]][current[1]]);
                current[0] += dirs[dirIter][0];
                current[1] += dirs[dirIter][1];
                count++;
            }
            len[lenIter] -= 2;
            lenIter = (lenIter + 1) % 4;
            dirIter = (dirIter + 1) % 4;
            if (dirIter == 0) {
                current[0]++;
                current[1]++;
            }
        }
        res.add(array[current[0]][current[1]]);
        return res;
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        ArrayList<Integer> res = new ArrayList<>();
        int rowIter = 0;
        int colIter = 0;
        int rowUpperBound = array[0].length;
        int colUpperBound = array.length;
        int rowLowerBound = 0;
        int colLowerBound = 0;
        int count = 0;
        int maxCount = rowUpperBound * colUpperBound;
        while(count < maxCount) {
            while (rowIter < rowUpperBound && count < maxCount) {
                res.add(array[colIter][rowIter]);
                rowIter++;
                count++;
            }
            rowIter--;
            colIter++;
            while (colIter < colUpperBound && count < maxCount) {
                res.add(array[colIter][rowIter]);
                colIter++;
                count++;
            }
            colIter--;
            rowIter--;
            while (rowIter > rowLowerBound && count < maxCount) {
                res.add(array[colIter][rowIter]);
                rowIter--;
                count++;
            }
            while (colIter > colLowerBound && count < maxCount) {
                res.add(array[colIter][rowIter]);
                colIter--;
                count++;
            }
            rowIter++;
            colIter++;
            rowUpperBound--;
            colUpperBound--;
            rowLowerBound++;
            colLowerBound++;
        }
        return res;
    }
}
