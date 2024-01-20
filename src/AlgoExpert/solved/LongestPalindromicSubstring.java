package AlgoExpert.solved;

public class LongestPalindromicSubstring {

    public static String longestPalindromicSubstring(String str) {
        int longest = 0;
        int index = 1;
        for (int i = 0; i < str.length(); i++) {
            int odd = helper(str, i, i);
            int even = helper(str, i, i + 1);
            if (Math.max(odd, even) > longest) {
                longest = Math.max(odd, even);
                index = i;
            }
        }
        boolean isEven = longest % 2 == 0;
        return longest > 1 ?
                (isEven ?
                        str.substring(index + 1  - (longest / 2)  , index + (longest / 2) + 1) :
                        str.substring(index - longest / 2, index + longest / 2 + 1)
                )
                : String.valueOf(str.charAt(0));
    }

    public static int helper(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }



    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("abaxyzzyxf"));
    }
}
