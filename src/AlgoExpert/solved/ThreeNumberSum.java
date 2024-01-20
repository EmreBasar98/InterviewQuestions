package AlgoExpert.solved;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeNumberSum {

    public static void main(String[] args) {
        int myArr [] = {12, 3, 1, 2, -6, 5, -8, 6};
        List<Integer[]> arr =  threeNumberSum(myArr, 0);
        for (Integer[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> res = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1, k = array.length - 1; j < k;) {
                int sum = array[i]  + array[j] + array[k];
                if (sum == targetSum) {
                    res.add(new Integer[]{array[i], array[j], array[k]});
                    j++;
                    k--;
                } else if (sum > targetSum) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
