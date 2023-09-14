import java.util.Arrays;
import java.util.List;

public class ProductDefects {
    public static void main(String[] args) {
//        List<List<Integer>> samples = Arrays.asList(Arrays.asList(1, 1, 1, 1, 1), Arrays.asList(1, 1, 1, 0, 0), Arrays.asList(1, 1, 1, 0, 0), Arrays.asList(1, 1, 1, 0, 0), Arrays.asList(1, 1, 1, 1, 1));
//        List<List<Integer>> samples = Arrays.asList(Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 0), Arrays.asList(1, 0, 1));
        List<List<Integer>> samples = Arrays.asList(Arrays.asList(0, 1, 1), Arrays.asList(1, 1, 0), Arrays.asList(1, 0, 1));
        System.out.println(findLargestSquareSize(samples));
    }

    public static int findLargestSquareSize(List<List<Integer>> samples) {
        int n = samples.size();
        for (int i = n; i > 0; i--) {
            for (int r = 0; r + i < n + 1 ; r++) {
                for (int c = 0; c + i < n + 1; c++) {
                    int count = 0;
                    for (int sr = 0; sr < i; sr++) {
                        for (int sc = 0; sc < i; sc++) {
                            if(samples.get(sr+r).get(sc+c) == 1) count++;
                        }
                    }
                    if (count == i*i) return i;
                }
            }
        }
        return 1;
    }
}
