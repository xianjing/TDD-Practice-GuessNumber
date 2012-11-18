import guessNumber.generator.RandomNumberGenerator;
import guessNumber.model.UniqueNumber;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static junit.framework.Assert.*;

public class NumberGeneratorTest {

    @Test
    public void should_return_four_numbers(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        UniqueNumber number = randomNumberGenerator.generate();
        assertEquals(4, number.size());
    }

    @Test
    public void should_return_four_unique_number(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        UniqueNumber number = randomNumberGenerator.generate();
        for(int i = 0; i < number.size(); i++) {
            int key = (Integer)number.get(i);
            int index = Arrays.binarySearch(number.toArray(), i + 1, number.size(), key);
            assertTrue(index < 0);
        }
    }

    @Test
    public void should_match_frequency_equality(){
        int tries = 50;
        ArrayList<UniqueNumber> numbers = createBatchUniqueNumbers(tries);
        Random random = new Random();
        int size = numbers.size();
        for (int i = 0; i < size; i++){
            UniqueNumber oneNumber = numbers.get(i);
            UniqueNumber anotherNumber = numbers.get(getRandomIndex(i, size, random));
            assertFalse(oneNumber.equals(anotherNumber));
        }
    }

    private ArrayList<UniqueNumber> createBatchUniqueNumbers(int tries) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        ArrayList<UniqueNumber> numbers = new ArrayList<UniqueNumber>();
        for(int i = 0; i < tries; i++){
            UniqueNumber result = randomNumberGenerator.generate();
            numbers.add(result);
        }
        return numbers;
    }

    private int getRandomIndex(int currentIndex, int size, Random random) {
        int result = random.nextInt(size);
        while(currentIndex == result)
        {
            result = random.nextInt(size);
        }
        return result;
    }
}
