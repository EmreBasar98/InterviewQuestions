package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.List;

public class Powerset {

    public static void main(String[] args) {
        System.out.println(powerset(List.of(1,2,3)));
    }

    //iterative approach
//    public static List<List<Integer>> powerset(List<Integer> array) {
//        List<List<Integer>> subsets = new ArrayList<>();
//        subsets.add(new ArrayList<>());
//
//        for (Integer element : array) {
//            int length = subsets.size();
//            for (int i = 0; i < length; i++) {
//                List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
//                currentSubset.add(element);
//                subsets.add(currentSubset);
//            }
//        }
//        return subsets;
//    }


    //recursive approach
    public static List<List<Integer>> powerset(List<Integer> array) {
        return helper(array,  array.size() - 1);
    }

    public static List<List<Integer>> helper(List<Integer> array, int idx) {
        if (idx < 0) {
            return new ArrayList<>(List.of(List.of()));
        }
        if (idx == 0) {
            return new ArrayList<>(List.of(List.of(), List.of(array.get(idx))));
        }
        List<List<Integer>> subsets = helper(array, idx - 1);
        int length = subsets.size();
        for (int i = 0; i < length; i++) {
            List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
            currentSubset.add(array.get(idx));
            subsets.add(currentSubset);
        }
        return subsets;
    }
}
