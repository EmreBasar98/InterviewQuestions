package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        if (array.size() == 0) return List.of();
        if (array.size() == 1) return List.of(array);
        List<List<Integer>> retArray = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            List<List<Integer>> permutations = new ArrayList<>();
            ArrayList<Integer> arrayToRemove = new ArrayList<>(array);
            arrayToRemove.remove(i);
            for (List<Integer> subPerm : getPermutations(arrayToRemove)) {
                ArrayList<Integer> perm = new ArrayList<>(List.of(array.get(i)));
                perm.addAll(subPerm);
                permutations.add(perm);
            }
            System.out.println(permutations);
            retArray.addAll(permutations);
        }
        return retArray;
    }

    public static void main(String[] args) {
        List<List<Integer>> ret = getPermutations(List.of(1, 2, 3));
        System.out.println("---------------");
        System.out.println(ret);
    }
}
