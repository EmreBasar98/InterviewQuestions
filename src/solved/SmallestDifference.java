package solved;

import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17})));
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int indexOne = 0;
        int indexTwo = 0;
        int currentDiff;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < arrayOne.length && j < arrayTwo.length;) {
            currentDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
            if(currentDiff < minDiff) {
                minDiff = currentDiff;
                indexOne = i;
                indexTwo = j;
            }
            if (currentDiff == 0) {
                return new int[]{arrayOne[i], arrayTwo[j]};
            } else if (arrayOne[i] > arrayTwo[j]) {
                j++;
            } else {
                i++;
            }
        }
        return new int[] {arrayOne[indexOne], arrayTwo[indexTwo]};
    }

}
