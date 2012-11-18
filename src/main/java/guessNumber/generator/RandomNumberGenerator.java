package guessNumber.generator;

import guessNumber.model.UniqueNumber;

import java.util.Random;

public class RandomNumberGenerator implements INumberGenerator {
    private Random random;
    private int MAX_NUMBER = 10;

    public RandomNumberGenerator() {
        random = new Random();
    }

    public UniqueNumber generate() {
        UniqueNumber uniqueNumber = new UniqueNumber(ALLOWED_DIGITS);
        for(int i = 0;i < ALLOWED_DIGITS;i++){
            int newMember = random.nextInt(MAX_NUMBER);

            while(uniqueNumber.contains(newMember)){
                newMember = random.nextInt(MAX_NUMBER);
            }
            uniqueNumber.add(newMember);
        }
        return uniqueNumber;
    }
}
