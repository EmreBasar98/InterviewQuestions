import java.util.Arrays;

public class TwoColorable {

    public static void main(String[] args) {
        int[][] edges = {{1}, {2, 4}, {2, 3}, {2, 4}, {1, 3}};
        System.out.println(twoColorable(edges));
    }

    public static boolean twoColorable(int[][] edges) {
        int[] colorArray = new int[edges.length];
        Arrays.fill(colorArray, -1);
        return helper(0, edges, colorArray, 0);
    }


    public static boolean helper(int node, int[][] edges, int[] colorArray, int color) {
        if (colorArray[node] != -1) {
            return colorArray[node] == color;
        }
        colorArray[node] = color;
        int nextColor = color == 1 ? 0 : 1;
        for (int adj = 0; adj < edges[node].length ; adj++) {
            if (edges[node][adj] == node) return false;
            if (!helper(edges[node][adj], edges, colorArray, nextColor)){
                return false;
            };
        }
        return true;
    }
}
