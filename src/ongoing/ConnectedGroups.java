import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConnectedGroups {
    public static void main(String[] args) {
        List<String> related = Arrays.asList("1000001000", "1110", "0110", "0001");
        System.out.println(countGroups(related));
    }

    public static int countGroups(List<String> related) {
        int[][] grid = convertToGrid(related);
        HashSet<List<Integer>> visited = new HashSet<>();
        int groupCount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length ; c++) {
                if(exploreGroup(grid, r, c, visited)) groupCount++;
            }
        }
        return groupCount;
    }

    public static int[][] convertToGrid(List<String> related) {
        int[][] grid = new int[related.size()][related.size()];
        System.out.println(Arrays.toString(grid[1]));
        for (int i = 0; i < related.size(); i++) {
            char[] rels = related.get(i).toCharArray();
            for (int j = 0; j < rels.length; j++) {
                grid[i][j] = Integer.parseInt(String.valueOf(rels[j]));
            }
        }
        return grid;
    }

    public static boolean exploreGroup(int[][] grid, int r, int c, HashSet<List<Integer>> visited) {
        boolean rowInbounds = 0 <= r && r < grid.length;
        boolean columInbounds = 0 <= c && c < grid[0].length;
        if (!(rowInbounds && columInbounds)) return false;

        if (grid[r][c] == 0)return false;

        List<Integer> pos = Arrays.asList(r, c);
        if (visited.contains(pos)) return false;
        visited.add(pos);

        exploreGroup(grid, r - 1, c, visited);
        exploreGroup(grid, r + 1, c, visited);
        exploreGroup(grid, r, c - 1, visited);
        exploreGroup(grid, r, c + 1, visited);

        return true;
    }
}
