package solved;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] arr = {
                { 19, 32, 33, 34, 25, 8},
                {16, 15, 14, 13, 12, 11},
                {18, 31, 36, 35, 26, 9},
                {1, 2, 3, 4, 5, 6},
                {20, 21, 22, 23, 24, 7},
                {17, 30, 29, 28, 27, 10}
        };
        System.out.println(spiralTraverse(arr));

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
