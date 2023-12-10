import java.util.Arrays;

public class MaxSubsetSumNoAdjacent {

    public static void main(String[] args) {
        int[] array = {4, 3, 5, 200, 5, 3};
        System.out.println(maxSubsetSumNoAdjacent(array));
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        int globalMaxSum = 0;
        int indexMaxSum = 0;
        int previousIndexMaxSum = 0;
        int previousPreviousIndexMaxSum = 0;
        for (int i = 0; i < array.length; i++) {
            previousPreviousIndexMaxSum = previousIndexMaxSum;
            previousIndexMaxSum = indexMaxSum;
            if (i == 0) {
                indexMaxSum = array[i];
            }
            else if(i == 1) {
                indexMaxSum = Math.max(array[i], array[i - 1]);
            }
            else {
                indexMaxSum = Math.max(previousIndexMaxSum, previousPreviousIndexMaxSum + array[i]);
            }
            if (indexMaxSum > globalMaxSum) {
                globalMaxSum = indexMaxSum;
            }
        }
        return globalMaxSum;
    }



}
