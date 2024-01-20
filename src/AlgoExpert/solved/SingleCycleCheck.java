package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SingleCycleCheck {


    public static void main(String[] args) {
        int[] arr = {10, 11, -6, -23, -2, 3, 88, 908, -26};
        System.out.println(hasSingleCycle(arr));
    }
    public static boolean hasSingleCycle(int[] array) {
        if (array.length == 0 || array.length == 1) return false;
        List<Integer> visited = new ArrayList<>();
        List<Integer> marked = new ArrayList<>();
        HashMap<Integer, Integer> graph = constructGraph(array);
        return findCycle(0, graph, visited, marked);
    }

    public static boolean findCycle(int current, HashMap<Integer, Integer> graph, List<Integer> visited, List<Integer> marked) {
        if (visited.contains(current) && !marked.contains(current)) {
            return current == 0 && visited.size() == graph.size();
        }
        visited.add(current);
        if (graph.get(current) != null && findCycle(graph.get(current), graph, visited, marked)) {
            return true;
        }
        marked.add(current);
        return false;
    }

    public static HashMap<Integer, Integer> constructGraph(int[] array) {
        HashMap<Integer, Integer> graph = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int neigh = i + (array[i] % array.length);
            while (neigh < 0) {
                neigh = neigh + array.length;
            }
            System.out.println(neigh);
            if (neigh != i) {
                graph.put(i, neigh % array.length);
            } else {
                graph.put(i, null);
            }
        }
        return graph;
    }

}
