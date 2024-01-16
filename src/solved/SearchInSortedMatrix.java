import java.util.Arrays;

public class SearchInSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004}
        };

        int target = 44;
        int[] result = searchInSortedMatrix(matrix, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {

        int currX = matrix.length - 1;
        int currY = 0;

        int boundY = matrix[0].length ;
        int currElem;

        while(currX > -1 && currY < boundY) {
            currElem = matrix[currX][currY];
            if(currElem == target) return new int[]{currX, currY};
            else if(currElem > target) currX--;
            else currY++;
        }
        return new int[]{-1, -1};

    }
}
