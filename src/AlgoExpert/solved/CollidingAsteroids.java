package AlgoExpert.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollidingAsteroids {

    public static void main(String[] args) {
        int[] asteroids = {4, -5, -2, -3};
        int[] result = collidingAsteroids(asteroids);
        System.out.println(Arrays.toString(result));
    }

    public static int[] collidingAsteroids(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) stack.add(asteroid);
            else {
                int lastAsteroid = stack.remove(stack.size() - 1);
                if (lastAsteroid > 0 && asteroid < 0) {
                    int collisionSum = lastAsteroid + asteroid;
                    if (collisionSum == 0) continue;
                    if (collisionSum > 0) stack.add(lastAsteroid);
                    else {
                        while (collisionSum < 0 && lastAsteroid > 0 && stack.size() > 0) {
                            lastAsteroid = stack.remove(stack.size() - 1);
                            collisionSum = lastAsteroid + asteroid;
                        }
                        if (lastAsteroid > 0) {
                            if (collisionSum > 0) stack.add(lastAsteroid);
                            else stack.add(asteroid);
                        } else {
                            stack.add(lastAsteroid);
                            stack.add(asteroid);
                        }
                    }
                } else {
                    stack.add(lastAsteroid);
                    stack.add(asteroid);
                }
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
