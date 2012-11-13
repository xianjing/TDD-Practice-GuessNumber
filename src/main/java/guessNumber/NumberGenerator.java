package guessNumber;

import java.util.Arrays;
import java.util.Random;

public class NumberGenerator implements INumberGenerator{
    private Random random;
    private int maximumInt = 10;

    public NumberGenerator() {
        random = new Random();
    }

    public int[] generate() {
        int[] result = new int[4];
        for(int i =0; i < 4; i++){
            result[i] = getRandomInt(result, maximumInt);
        }
        return result;
    }

    private int getRandomInt(int[] existingValues, int bound) {
        int result = random.nextInt(bound);
        while(Arrays.binarySearch(existingValues, result) >= 0)
        {
            result = random.nextInt(bound);
        }
        return result;
    }
}
