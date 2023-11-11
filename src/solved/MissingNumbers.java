import java.util.Arrays;

public class MissingNumbers {

    public static int[] missingNumbers(int[] nums) {
        int sum =0;
        int n = nums.length + 2;
        for (Integer i : nums) {
            sum += i;
        }


        int shouldSum = (n * (n + 1)) / 2;
        int difference = shouldSum - sum;

        int avg = difference / 2;
        int leftHandSum = 0;
        for (Integer i : nums) {
            if (i <= avg) {
                leftHandSum += i;
            }
        }

        int leftHandMaxSum = (avg * (avg + 1)) / 2;
        int smallerMissingNumber = leftHandMaxSum - leftHandSum;
        int greaterMissingNumber = difference - smallerMissingNumber;
        return new int[] {smallerMissingNumber, greaterMissingNumber};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(missingNumbers(new int[]{1, 4, 3, 6, 5})));
    }
}
