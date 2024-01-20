package AlgoExpert.solved;

public class OneEdit {

    public static void main(String[] args) {
        System.out.println(oneEdit("helloa", "heloi"));
    }

    public static boolean oneEdit(String stringOne, String stringTwo) {
        int lenOne = stringOne.length();
        int lenTwo = stringTwo.length();
        if (Math.abs(lenOne - lenTwo) > 1) {
            return false;
        }
        int diffCount = 0;
        if (lenOne == lenTwo) {
            for (int i = 0 ; i <lenOne; i++) {
                if (stringOne.charAt(i) != stringTwo.charAt(i)) diffCount++;
            }
            return diffCount < 2;
        } else {
            String biggerString = lenOne > lenTwo ? stringOne : stringTwo;
            String smallerString = lenOne > lenTwo ? stringTwo : stringOne;

            int biggerLen = biggerString.length();
            int smallerLen = smallerString.length();
            int biggerIndex = 0;
            int smallerIndex = 0;

            while (biggerIndex < biggerLen && smallerIndex < smallerLen) {
                if (biggerString.charAt(biggerIndex) != smallerString.charAt(smallerIndex)) {
                    if (diffCount > 0) return false;
                    else {
                        biggerIndex++;
                        diffCount++;
                    }
                } else {
                    biggerIndex++;
                    smallerIndex++;
                }
            }
        }
        return true;
    }
}
