package AlgoExpert.solved;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(List<String> words) {
        List<String> sortedWords = new ArrayList<>();
        Map<String, List<Integer>> occurMap = new HashMap<>();
        List<List<String>> retArray = new ArrayList<>();
        for (String s : words) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            sortedWords.add(String.copyValueOf(temp));
        }

        for (int i = 0; i < sortedWords.size(); i++) {
            occurMap.computeIfAbsent(sortedWords.get(i), k -> new ArrayList<>()).add(i);
        }

        for (Map.Entry<String, List<Integer>> entry: occurMap.entrySet()) {
            List<String> temp = new ArrayList<>();
            for (Integer index : entry.getValue()) {
                temp.add(words.get(index));
            }
            retArray.add(temp);
        }
        return retArray;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(List.of("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")));
    }
}
