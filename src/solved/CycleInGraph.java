import java.util.HashSet;
import java.util.Set;

public class CycleInGraph {

    public static void main(String[] args) {
        System.out.println(cycleInGraph(new int[][]{{}, {0, 3}, {0}, {1, 2}}));
    }

    public static boolean cycleInGraph(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            Set<Integer> visited = new HashSet<>();
            Set<Integer> visiting = new HashSet<>();
            if (travel(i, visited, visiting, edges)) return true;
        }
        return false;
    }

    public static boolean travel(int vertex, Set<Integer> visited, Set<Integer> visiting, int[][] edges) {
        if (visited.contains(vertex)) return false;
        if (visiting.contains(vertex)) return true;
        visiting.add(vertex);
        for (int edge : edges[vertex]) {
            if (travel(edge, visited, visiting, edges)) return true;
        }
        visiting.remove(vertex);
        visited.add(vertex);
        return false;
    }

}
