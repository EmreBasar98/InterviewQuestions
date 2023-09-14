import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AllRoadsLeadToRome {
    public static void main(String[] args) {
        List<List<Integer>> roads = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 2), Arrays.asList(4, 2));
        System.out.println(findRome(9, roads));
    }

    public static int findRome(int n, List<List<Integer>> roads) {
        HashMap<Integer, List<Integer>> adjList = createAdjList(roads);
        return searchRome(adjList, 1);
    }

    public static HashMap<Integer, List<Integer>> createAdjList(List<List<Integer>> roads) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (List<Integer> l : roads){
            int from = l.get(0);
            int to = l.get(1);
            if (!adjList.containsKey(from)) adjList.put(from, new ArrayList<>());
            adjList.get(from).add(to);
        }
        return adjList;
    }

    public static int searchRome(HashMap<Integer, List<Integer>> adjList, int source) {
        if(adjList.get(source) == null)return source;
        int rome = source;
        for (int neigh: adjList.get(source)) {
            rome = searchRome(adjList, neigh);
        }
        return rome;
    }
}
