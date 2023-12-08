import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberMnemonics {

    public static void main(String[] args) {
        System.out.println(phoneNumberMnemonics("1905"));
    }

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        Map<Character, String[]> map = new HashMap<>();
        map.put('0', new String[]{"0"});
        map.put('1', new String[]{"1"});
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        return helper(phoneNumber, phoneNumber.length() - 1, map);
    }

    public static ArrayList<String> helper(String phoneNumber, int idx, Map<Character, String[]> map) {
        if (idx == 0) {
            return new ArrayList<>(List.of(map.get(phoneNumber.charAt(idx))));
        }

        ArrayList<String> prevMnemonics = helper(phoneNumber, idx - 1, map);
        ArrayList<String> newMnemonics = new ArrayList<>();

        StringBuilder sb;
        for (String currentMnemonic : prevMnemonics) {
            for (String letter : map.get(phoneNumber.charAt(idx))) {
                sb = new StringBuilder(currentMnemonic);
                sb.append(letter);
                newMnemonics.add(sb.toString());
            }
        }

        return newMnemonics;
    }

}
