public class MaximalSquare {
    public static void main(String[] args) {
char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(matrix));
    }

    //    Tabulation Approach
    //
    //      - Cache the info, for a particular cell being top-left, the largest square for that cell
    //      - Return max val in that cache
    //
    public static int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] cache = new int[n][m];

        for (int i = 0; i < n; i++) {
            cache[i][m-1] = matrix[i][m-1] == '1' ? 1 : 0;
        }
        for (int i = 0; i < m; i++) {
            cache[n-1][i] = matrix[n-1][i] == '1' ? 1 : 0;
        }

        for (int r = n-2; r > - 1 ; r--) {
            for (int c = m-2; c > -1; c--) {
                if (matrix[r][c] == '1') {
                    cache[r][c] = Math.min(cache[r+1][c+1], Math.min(cache[r+1][c], cache[r][c+1])) + 1;
                }
            }
        }
        int max = 0;
        for (int ir = 0; ir < n; ir++) {
            for (int ic = 0; ic < m ; ic++) {
                if (cache[ir][ic] > max) max = cache[ir][ic];
            }
        }
        return max*max;
    }

//    Brute Force Approach
//
//      - Start with the largest possible square window and check if it is a square
//      - Shrink the window size and check if it is a square for every possible top left corner cell
//
//    public static int maximalSquare(char[][] matrix) {
//        int n = matrix.length;
//        for (int i = n; i > 0; i--) {
//            for (int r = 0; r + i < n + 1 ; r++) {
//                for (int c = 0; c + i < n + 1; c++) {
//                    int count = 0;
//                    for (int sr = 0; sr < i; sr++) {
//                        for (int sc = 0; sc < i; sc++) {
//                            if(matrix[sr+r][sc+c] == '1') count++;
//                        }
//                    }
//                    if (count == i*i) return i*i;
//                }
//            }
//        }
//        return 0;
//    }
}
