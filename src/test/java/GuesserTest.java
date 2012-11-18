import guessNumber.guessor.Guesser;
import guessNumber.model.UniqueNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GuesserTest {

    private UniqueNumber userInput;
    private String expected;
    private final UniqueNumber randomNumber;

    public GuesserTest(UniqueNumber userInput, String expected) {
        this.userInput = userInput;
        this.expected = expected;
        randomNumber = unique(new int[]{1, 2, 3, 4});
    }

    @Parameterized.Parameters
    public static Collection fixtures(){
        Object[][] data = new Object[][]{
                {unique(new int[]{1,2,3,4}), "4a0b"},
                {unique(new int[]{1,2,3,5}), "3a0b"},
                {unique(new int[]{1,2,5,6}), "2a0b"},
                {unique(new int[]{1,2,4,6}), "2a1b"},
                {unique(new int[]{1,2,4,3}), "2a2b"},
                {unique(new int[]{5,6,7,3}), "0a1b"},
                {unique(new int[]{5,6,7,8}), "0a0b"}
        };

        return Arrays.asList(data);
                
    }
    

    @Test
    public void should_validate_input(){
        Guesser guesser = new Guesser(randomNumber);
        String result = guesser.verify(userInput);
        assertEquals(expected, result);
    }
    
    private static UniqueNumber unique(int[] input){
        return new UniqueNumberBuilder().withNumbers(input).build();
    }
}