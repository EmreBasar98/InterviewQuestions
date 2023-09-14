import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FootballScores {
    public static void main(String[] args) {
        System.out.println(counts(Arrays.asList(2,10,5,4,8), Arrays.asList(3,1,7,8)));
    }
    
    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB){
        List<Integer> matchCounts = new ArrayList<>();
        for (int goalsB: teamB) {
            int goalCount = 0;
            for (int goalsA: teamA) {
                if(goalsA <= goalsB) {
                    goalCount++;
                }
            }
            matchCounts.add(goalCount);
        }
        return matchCounts;
    }
}
