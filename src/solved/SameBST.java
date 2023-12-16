import java.util.List;
import java.util.Objects;

public class SameBST {

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) return false;
        if (arrayOne.size() == 0 ) return true;
        if (!Objects.equals(arrayOne.get(0), arrayTwo.get(0))) return false;
        int root = arrayOne.get(0);
        List<Integer> leftTreeOne = arrayOne.subList(1, arrayOne.size()).stream().filter(x -> x < root).toList();
        List<Integer> rightTreeOne = arrayOne.subList(1, arrayOne.size()).stream().filter(x -> x >= root).toList();
        List<Integer> leftTreeTwo = arrayTwo.subList(1, arrayTwo.size()).stream().filter(x -> x < root).toList();
        List<Integer> rightTreeTwo = arrayTwo.subList(1, arrayTwo.size()).stream().filter(x -> x >= root).toList();
        //TODO : sublist kullanmadan nasıl yapılacağını incelemek lazım
        return sameBsts(leftTreeOne, leftTreeTwo) && sameBsts(rightTreeOne, rightTreeTwo);
    }

    public static void main(String[] args) {
        System.out.println(sameBsts(List.of(10, 15, 8, 12, 94, 81, 5, 2, 11), List.of(10, 8, 5, 15, 2, 12, 11, 94, 81)));
    }
}
