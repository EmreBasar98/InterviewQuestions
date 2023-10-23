
public class IsMonotonic {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{-5,-4,-3}));
    }

    public static boolean isMonotonic(int[] array) {
        if (array.length == 0 || array.length == 1) return true;
        boolean isDecreasing = array[0] > array[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            if (isDecreasing && array[i] < array[i + 1]) return false;
            if (!isDecreasing && array[i] > array[i + 1]) return false;
        }
        return true;
    }
}
