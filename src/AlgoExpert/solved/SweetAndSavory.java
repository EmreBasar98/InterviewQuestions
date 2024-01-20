package AlgoExpert.solved;

import java.util.Arrays;

public class SweetAndSavory {

    public static int[] sweetAndSavory(int[] dishes, int target) {
        Arrays.sort(dishes);
        int low = 0; // 1
        int high = dishes.length - 1; // 5 -> 32
        int[] res = new int[2];
        int closestSum = 10000;
        while(low < high){
            if(dishes[low] > 0 && dishes[high] > 0) break;
            if(dishes[low] < 0 && dishes[high] < 0) break;
            int curSum = dishes[low] + dishes[high];  // -538 + 32 = -506
            if(Math.abs(curSum - target) < Math.abs(closestSum - target) && curSum <= target){
                closestSum = curSum; // 2
                res[0] = dishes[low]; // -538
                res[1] = dishes[high]; // 540
            }
            if(curSum < target) low++;
            else high--;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(sweetAndSavory(new int[]{2, 4, -4, -7, 12, 100, -25}, -1)));
    }
}
