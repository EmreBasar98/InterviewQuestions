package AlgoExpert.solved;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayOfProducts {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 4, 2};
        System.out.println(Arrays.toString(arrayOfProducts(arr)));
    }


    public static int[] arrayOfProducts(int[] array) {
        int leftHandProduct = 1;
        int rightHandProduct = 1;
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                leftHandProduct *= array[i-1];
            }
            res[i] = leftHandProduct;
        }
        for (int i = array.length - 1; i > -1; i--) {
            if (i != array.length - 1) {
                rightHandProduct *= array[i+1];
            }
            res[i] *= rightHandProduct;
        }
        return res;
    }
}
