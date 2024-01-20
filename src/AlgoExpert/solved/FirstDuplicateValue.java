package AlgoExpert.solved;

import java.util.Arrays;

public class FirstDuplicateValue {
    public static void main(String[] args) {
        System.out.println(firstDuplicateValue(new int[]{2, 1, 5, 3, 3, 2, 4}));
    }

    public static int firstDuplicateValue(int[] array) {
        int newIndex;
        for (int i = 0; i < array.length; i++) {
            newIndex = Math.abs(array[i]) - 1;
            if (array[newIndex] < 0) return Math.abs(array[i]);
            array[newIndex] *= - 1;
            System.out.println(Arrays.toString(array));
        }
        return -1;
    }
}
