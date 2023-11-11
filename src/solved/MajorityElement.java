public class MajorityElement {

    // Any number that is not majority can be consumed by other numbers and in the remaining sub-array
    // the real majority will remain as majority. Even you used the real majority the number of majority
    // elements will be greater than number of other elements among the remaining elements. Since there
    // can be n non-major and n+1 major elements in a 2n+1 sized array. Even if you use the n non-major
    // elements to consume major elements the remaining 1 will be the majority. Selecting the real
    // majority does not affect here since choosing a non-major element simply means to consume the
    // majority elements by using it to consume chosen element.

    public static int majorityElement(int[] array) {
        int guess = array[0];
        int guessHitCount = 0;
        for (int i = 0; i <array.length ; i++) {
            if(array[i] == guess) guessHitCount++;
            else guessHitCount--;
            if (guessHitCount < 1) {
                if (i == array.length - 1) break;
                guess = array[i + 1];
            }
        }
        return guessHitCount > 0 ? guess : -1;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 2, 1, 2, 6}));
    }
}
