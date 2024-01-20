package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String string = "AlgoExpert is the best!  ";
        String expected = "best! the is AlgoExpert";
        var actual = reverseWordsInString(string);
        System.out.println(expected.equals(actual));
    }

    public static String reverseWordsInString(String string) {
        StringBuilder currentWord = new StringBuilder();
        List<String> wordStack = new ArrayList<>();
        for (char c : string.toCharArray()) {
            if (c != ' ') {
                currentWord.append(c);
            } else {
                wordStack.add(currentWord.toString());
                wordStack.add(" ");
                currentWord = new StringBuilder();
            }
        }
        if (!currentWord.isEmpty()) wordStack.add(currentWord.toString());

        StringBuilder resultString = new StringBuilder();
        for (int i = wordStack.size() - 1 ; i > -1 ; i--) {
            resultString.append(wordStack.get(i));
        }

        return resultString.toString();
    }
}
