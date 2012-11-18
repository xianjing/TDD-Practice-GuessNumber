package guessNumber.generator;

import guessNumber.generator.INumberGenerator;
import guessNumber.model.UniqueNumber;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberGenerator implements INumberGenerator {
    private Random random;
    private int maximumInt = 10;

    public RandomNumberGenerator() {
        random = new Random();
    }

    public UniqueNumber generate1() {
        UniqueNumber uniqueNumber = new UniqueNumber(4);
        for(int i = 0;i < 4;i++){
            int newMember = random.nextInt(maximumInt);

            while(uniqueNumber.contains(newMember)){
                newMember = random.nextInt(maximumInt);
            }
            uniqueNumber.add(newMember);
        }
        return uniqueNumber;
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
