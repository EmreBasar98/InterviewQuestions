package AlgoExpert.solved;

import java.util.*;

public class CommonCharacters {

    public static String[] commonCharacters(String[] strings) {
        List<String> ret = new ArrayList<>();
        int numOfString = strings.length;
        Map<Character, Integer> occurMap = new HashMap<>();
        Set<Character> set;
        for (String s : strings) {
            set = new HashSet<>(Arrays.asList(s.chars().mapToObj(c -> (char) c).toArray(Character[]::new)));
            for (Character c : set) {
                occurMap.put(c, occurMap.getOrDefault(c, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : occurMap.entrySet()) {
            if (entry.getValue() == numOfString) {
                ret.add(entry.getKey().toString());
            }
        }
        return ret.toArray(new String[0]);
    }
    public static void main(String[] args) {
        String[] strings = {"bella","label","roller"};
        System.out.println(Arrays.toString(commonCharacters(strings)));
    }
}
