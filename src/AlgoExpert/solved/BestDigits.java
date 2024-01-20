package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.List;

public class BestDigits {


    public static void main(String[] args) {
        BestDigits bestDigits = new BestDigits();
        System.out.println(bestDigits.bestDigits("462839", 2));
    }


    public String bestDigits(String number, int numDigits) {
        List<Character> digitStack = new ArrayList<>();
        for (Character digit: number.toCharArray()) {
            if (digitStack.isEmpty()) digitStack.add(digit);
            else {
                while (numDigits > 0 && digitStack.size() > 0 && digitStack.get(digitStack.size() - 1) <= digit) {
                    digitStack.remove(digitStack.size() - 1);
                    numDigits--;
                }
                digitStack.add(digit);
            }
        }
        while (numDigits > 0 && digitStack.size() > 0) {
            digitStack.remove(digitStack.size() - 1);
            numDigits--;
        }
        return digitStack.stream().map(String::valueOf).reduce("", String::concat);
    }
}
