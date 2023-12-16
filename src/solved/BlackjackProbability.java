import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class BlackjackProbability {

    public static void main(String[] args) {
        System.out.println(blackjackProbability(21, 20));
    }

    public static float blackjackProbability(int target, int startingHand) {
        return helper(target, startingHand, new HashMap<>());
    }
//
//    public static float helper(int target, int currentHand, Map<Integer, Float> memo) {
//        if (memo.containsKey(currentHand)) {
//            return memo.get(currentHand);
//        }
//        if (currentHand > target) return 1;
//        if (currentHand >= target - 4) return 0;
//
//        float resultProbability = 0;
//        for (int i = 1; i < 11; i++) {
//            resultProbability += 0.1 * helper(target, currentHand + i, memo);
//        }
//        memo.put(currentHand, resultProbability);
//        return Math.round(resultProbability * 1000f)/1000f;
//    }


    public static float helper(int target, int currentHand, Map<Integer, Float> memo) {
        if (memo.containsKey(currentHand)) {
            return memo.get(currentHand);
        }
        if (currentHand == target) return 0;
        if (currentHand > target) return 1;
        if (currentHand >= target - 4) return 0;
        int bustCounter = 0;
        float keepDrawingPossibilities = 0;

        for (int i = 1; i < 11; i++) {
            if (currentHand + i < target - 4){
                keepDrawingPossibilities += helper(target, currentHand + i, memo);
            }
            else if (currentHand + i > target){
                bustCounter++;
            }
        }

        float result = ((float) bustCounter + keepDrawingPossibilities) / (float)10;
        result = Math.round(result * 1000f)/1000f;
        memo.put(currentHand, result);
        return result;
    }
}
