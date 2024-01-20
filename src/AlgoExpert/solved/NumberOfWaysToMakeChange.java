package AlgoExpert.solved;

public class NumberOfWaysToMakeChange {
    public static void main(String[] args) {
        int[] denoms = {1, 5};
        int n = 6;
        System.out.println(numberOfWaysToMakeChange(n, denoms));
    }


    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int denom : denoms) {
            for (int i = 1; i < n + 1; i++) {
                if (denom <= i) {
                    ways[i] += ways[i - denom];
                }
            }
        }
        return ways[n];
    }

}
