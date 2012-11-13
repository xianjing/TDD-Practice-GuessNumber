import guessNumber.NumberGenerator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static junit.framework.Assert.*;

public class NumberGeneratorTest {

    @Test
    public void should_return_four_numbers(){
        NumberGenerator numberGenerator = new NumberGenerator();
        int[] number = numberGenerator.generate();
        assertEquals(4, number.length);
    }

    @Test
    public void should_return_four_unique_number(){
        NumberGenerator numberGenerator = new NumberGenerator();
        int[] number = numberGenerator.generate();
        for(int i = 0; i < number.length; i++) {
            int key = number[i];
            int index = Arrays.binarySearch(number,i+1, number.length, key);
            assertTrue(index < 0);
        }
    }

    @Test
    public void should_match_frequency_equality(){
        NumberGenerator numberGenerator = new NumberGenerator();
        ArrayList<int[]> numbers = new ArrayList<int[]>();
        int tries = 2;
        for(int i = 0; i < tries; i++){
            int[] result = numberGenerator.generate();
            numbers.add(result);
        }
        Random random = new Random();
        for (int i = 0; i < tries; i++){
            int[] oneNumber = numbers.get(i);
            int[] anotherNumber = numbers.get(getRandomIndex(i, tries, random));
            assertTrue(notEqual(oneNumber, anotherNumber));
        }
    }

    private int getRandomIndex(int currentIndex, int size, Random random) {
        int result = random.nextInt(size);
        while(currentIndex == result)
        {
            result = random.nextInt(size);
        }
        return result;
    }

    private boolean notEqual(int[] firstNumber, int[] secondNumber) {
        for (int i =0; i < firstNumber.length; i++){
            if(firstNumber[i] != secondNumber[i]){
                return true;
            }
        }
        return false;
    }
}
