import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {


    public static boolean zeroSumSubarray(int[] nums) {
        int sum = 0;
        if (nums.length == 0) return false;
        Set<Integer> visitedSum = new HashSet<>();
        for (int num : nums) {
            sum += num;
            if (sum == 0 || visitedSum.contains(sum)) return true;
            visitedSum.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {9, -5, -4, 2, 3};
        System.out.println(zeroSumSubarray(nums));
    }
}
