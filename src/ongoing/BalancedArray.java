import java.util.Arrays;
import java.util.List;

public class BalancedArray {
    public static void main(String[] args) {
        System.out.println(balancedSum(Arrays.asList(1,2,3,3,4,6,1,3,7,2)));
    }

    public static int balancedSum(List<Integer> arr) {
        int minPivotIndex = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            int leftSum = 0;int rightSum = 0;
            for (int j = 0; j < arr.size(); j++) {
                if (j<i) {
                    leftSum += arr.get(j);
                } else if(j>i) {
                    rightSum += arr.get(j);
                }
            }
            if (leftSum == rightSum && i < minPivotIndex) minPivotIndex = i;
        }
        return minPivotIndex;
    }
}
