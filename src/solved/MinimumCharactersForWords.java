import java.util.*;

public class MinimumCharactersForWords {
    public static void main(String[] args) {
        String[] words = new String[] {"this", "that", "did", "deed", "them!", "a"};
        char[] result = minimumCharactersForWords(words);
        System.out.println(result);
    }

    public static char[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> resultFreqMap = new HashMap<>();
        Map<Character, Integer> wordFreqMap = new HashMap<>();
        for (String word: words) {
            wordFreqMap.clear();
            for (char c: word.toCharArray()) {
                wordFreqMap.put(c, wordFreqMap.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry: wordFreqMap.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                if (resultFreqMap.containsKey(key)) {
                    resultFreqMap.put(key, Math.max(resultFreqMap.get(key), value));
                } else {
                    resultFreqMap.put(key, value);
                }
            }
        }

        int valCount = 0;
        for (Map.Entry<Character, Integer> entry: resultFreqMap.entrySet()) {
            valCount += entry.getValue();
        }

        char[] result = new char[valCount];
        int index = 0;
        for (Map.Entry<Character, Integer> entry: resultFreqMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < value; i++) {
                result[index] = key;
                index++;
            }
        }
        return result;
    }

}
