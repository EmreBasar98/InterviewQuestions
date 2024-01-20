package AlgoExpert.solved;

public class BestSeat {


    public static int bestSeat(int[] seats) {
        int emptySpaceCount = 0;
        int emptyStart;
        int maxSpace = 0;
        int maxEmptyStart = 0;
        for (int i = 0; i <seats.length ; i++) {
            if (seats[i] == 0) {
                emptyStart = i;
                while (seats[i] != 1) {
                    emptySpaceCount++;
                    i++;
                }
                if (emptySpaceCount > maxSpace) {
                    maxSpace = emptySpaceCount;
                    maxEmptyStart = emptyStart;
                }
                emptySpaceCount = 0;
            }
        }
        int ret = ((maxEmptyStart - 1)  + (maxEmptyStart + maxSpace)) /2;
        return ret < 1 ? -1 : ret;
    }

    public static void main(String[] args) {
        int[] seats = {1, 0, 1, 1, 1, 0, 1, 0, 1};
        System.out.println(bestSeat(seats));
    }
}
