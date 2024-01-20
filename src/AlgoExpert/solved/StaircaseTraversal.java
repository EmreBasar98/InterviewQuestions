package AlgoExpert.solved;

import java.util.HashMap;
import java.util.Map;

public class StaircaseTraversal {

    public static void main(String[] args) {
        System.out.println(staircaseTraversal(4, 2));
    }

//    public static int staircaseTraversal(int height, int maxSteps) {
//        return helper(maxSteps, height, new HashMap<>());
//    }
//
//    public static int helper(int maxSteps, int remSteps, Map<Integer, Integer> memo) {
//        if (memo.containsKey(remSteps)) {
//            return memo.get(remSteps);
//        }
//        if (remSteps == 0) {
//            return 1;
//        }
//        if (remSteps < 0) {
//            return 0;
//        }
//        int ways = 0;
//        for (int i = 1; i <= maxSteps; i++) {
//            ways += helper(maxSteps, remSteps - i, memo);
//        }
//        memo.put(remSteps, ways);
//        return ways;
//    }
    public static int staircaseTraversal(int height, int maxSteps) {
        int[] counter = new int[1];
        helper(maxSteps, counter, height, new HashMap<>());
        return counter[0];
    }

    public static void helper(int maxSteps, int[] counter, int remSteps, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(remSteps)) {
            counter[0] += memo.get(remSteps);
            return;
        }
        for (int i = 1; i < maxSteps + 1; i++) {
            if (i < remSteps) helper(maxSteps, counter, remSteps - i, memo);
            if (i == remSteps) {
                counter[0]++;
                break;
            }
        }
        memo.put(remSteps, counter[0]);
    }
}
