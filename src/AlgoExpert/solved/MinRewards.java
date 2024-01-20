package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinRewards {

    public static void main(String[] args) {
        int[] scores = {0, 4, 2, 1, 3};
        System.out.println(minRewards(scores));
    }

    public static int minRewards(int[] scores) {
        if (scores.length == 1) return 1;
        List<Integer> localMins = new ArrayList<>();
        for (int i = 0 ; i < scores.length ; i++) {
            if (i == 0) {
               if (scores[i] < scores[i + 1 ])localMins.add(i);
            }
            else if (i == scores.length -1 ) {
                if (scores[i] < scores[i - 1 ])localMins.add(i);
            }
            else {
                if ( scores[i] < scores[i + 1 ] && scores[i] < scores[i - 1 ]) localMins.add(i);
            }
        }
        int[] rewArr = new int[scores.length];
        Arrays.fill(rewArr, 1);
        for (int localMin : localMins) {
            for (int i = localMin - 1; i > -1; i--) {
                rewArr[i] = Math.max(rewArr[i + 1] + 1, rewArr[i]);
                if (i == 0 || ((scores[i] > scores[i-1]) && (scores[i] > scores[i+1]))){
                    break;
                }
            }
        }

        for (int localMin : localMins) {
            for (int i = localMin + 1; i < scores.length ; i++) {
                rewArr[i] = Math.max(rewArr[i - 1] + 1, rewArr[i]);
                if (i == scores.length - 1  || ((scores[i] > scores[i-1]) && (scores[i] > scores[i+1]))){
                    break;
                }
            }
        }
        int reward = 0;
        for (int rew : rewArr) {
            reward += rew;
        }
        return reward;
    }
}
