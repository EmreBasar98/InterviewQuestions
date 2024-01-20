package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.List;

public class MoveElementToEnd {
    public static void main(String[] args) {
        System.out.println(moveElementToEnd(new ArrayList<>(List.of(2, 1, 2, 2, 2, 3, 4, 2)), 2));
    }

//    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
//        int count = 0;
//        ArrayList<Integer> res = new ArrayList<>();
//        for (int a: array) {
//            if (a == toMove) {
//                count++;
//            } else {
//                res.add(a);
//            }
//        }
//        for (int i = 0; i < count; i++) {
//            res.add(toMove);
//        }
//        return res;
//    }
public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int leftPointer = 0;
        int rightPointer = array.size() - 1;
        while (leftPointer < rightPointer) {
            if (array.get(leftPointer) == toMove) {
                if (array.get(rightPointer) != toMove){
                    array.set(leftPointer, array.get(rightPointer));
                    array.set(rightPointer, toMove);
                    leftPointer++;
                }
                rightPointer--;
            } else {
                if (array.get(rightPointer) == toMove){
                    rightPointer--;
                }
                leftPointer++;
            }
        }
    return array;
}
}
