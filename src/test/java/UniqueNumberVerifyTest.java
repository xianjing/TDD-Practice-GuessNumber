import guessNumber.guessor.GuessResult;
import guessNumber.model.UniqueNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UniqueNumberVerifyTest {

    private UniqueNumber anotherNumber;
    private GuessResult expected;

    public UniqueNumberVerifyTest(int[] number, int expectedNumberOfA, int expectedNumberOfB) {
        this.anotherNumber = createUniqueNumber(number);
        this.expected = new GuessResult(expectedNumberOfA, expectedNumberOfB);
    }

    @Parameterized.Parameters
    public static Collection fixtures(){
        Object[][] data = new Object[][]{
                {new int[]{1,2,3,4}, 4, 0},
                {new int[]{1,2,3,5}, 3, 0},
                {new int[]{1,2,5,6}, 2, 0},
                {new int[]{1,2,4,6}, 2, 1},
                {new int[]{1,2,4,3}, 2, 2},
                {new int[]{5,6,7,3}, 0, 1},
                {new int[]{5,6,7,8}, 0, 0}
        };

        return Arrays.asList(data);
    }

    @Test
    public void should_validate_input(){
        UniqueNumber oneNumber = createUniqueNumber(new int[]{1, 2, 3, 4});
        GuessResult result = oneNumber.verify(anotherNumber);
        assertEquals(expected, result);
    }
    
    private static UniqueNumber createUniqueNumber(int[] input){
        return new UniqueNumberBuilder().withNumbers(input).build();
    }
}