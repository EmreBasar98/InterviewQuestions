import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SharedInterest {
    public static void main(String[] args) {
        int friendsNodes = 4;
        int friend_edges = 5;
        List<Integer> friendsFrom = Arrays.asList(1,1,2,2,2);
        List<Integer> friendsTo = Arrays.asList(2,2,3,3,4);
        List<Integer> friendsWeight = Arrays.asList(2,3,1,3,4);
        maxShared(friendsNodes, friendsFrom,friendsTo,friendsWeight);
    }

    public static int maxShared(int friendsNodes, List<Integer> friendsFrom, List<Integer> friendsTo, List<Integer> friendsWeight) {
        HashMap <Integer, List<List<Integer>>> weights = new HashMap<>();
        for (int i = 0; i < friendsFrom.size(); i++) {
            if(!weights.containsKey(friendsWeight.get(i))) weights.put(friendsWeight.get(i), new ArrayList<>());
            weights.get(friendsWeight.get(i)).add(Arrays.asList(friendsFrom.get(i), friendsTo.get(i)));
        }

        return 0;
    }

}
