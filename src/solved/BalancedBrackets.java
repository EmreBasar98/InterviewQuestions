import java.util.ArrayList;
import java.util.List;

public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println(balancedBrackets("([])(){}(())()(]"));
    }

    public static boolean balancedBrackets(String str) {
        List<Character> stack = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.add(c);
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                Character lastBracket = stack.remove(stack.size() - 1);
                if (!matchingBrackets(lastBracket, c)) {
                    stack.add(lastBracket);
                    stack.add(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean matchingBrackets(Character br1, Character br2) {
        if (br1 == '(' && br2 == ')') return true;
        if (br1 == '[' && br2 == ']') return true;
        return br1 == '{' && br2 == '}';
    }
}
