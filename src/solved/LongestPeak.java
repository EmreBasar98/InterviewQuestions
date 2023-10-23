
public class LongestPeak {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1, 2, 10, 12};
//        int[] arr = new int[]{5, 4, 3, 2, 1, 2, 1};
        System.out.println(longestPeak(arr));
    }

    public static int longestPeak(int[] array) {
        if (array.length < 3) return 0;
        int leftHandLen = 0;
        int rightHandLen = 0;
        int maxCount = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i-1] < array[i] && array[i] > array[i+1]) {
                int tempIter = i;
                while (tempIter > 0 && array[tempIter] > array[tempIter - 1]) {
                    tempIter--;
                    leftHandLen++;
                }
                tempIter = i;
                while (tempIter < array.length - 1 && array[tempIter] > array[tempIter + 1]) {
                    tempIter++;
                    rightHandLen++;
                }
                if ((rightHandLen + leftHandLen + 1) > maxCount) maxCount = rightHandLen + leftHandLen + 1;
                rightHandLen = 0;
                leftHandLen = 0;
            }
        }
        return maxCount;
    }
}
