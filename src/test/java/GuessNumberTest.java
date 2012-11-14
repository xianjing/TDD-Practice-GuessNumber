import guessNumber.GuessNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GuessNumberTest {

    private String userInput;
    private String expected;
    private final int[] randomNumber;

    public GuessNumberTest(String userInput, String expected) {
        this.userInput = userInput;
        this.expected = expected;
        randomNumber = new int[]{1, 2, 3, 4};
    }

    @Parameterized.Parameters
    public static Collection fixtures(){
        Object[][] data = new Object[][]{
                {"1234", "4a0b"},
                {"1235", "3a0b"},
                {"1256", "2a0b"},
                {"1246", "2a1b"},
                {"1243", "2a2b"},
                {"5673", "0a1b"},
                {"5678", "0a0b"}
        };

        return Arrays.asList(data);
                
    }

    @Test
    public void should_validate_input(){
        GuessNumber guessNumber = new GuessNumber(randomNumber);
        String result = guessNumber.validate(userInput);
        assertEquals(expected, result);
    }

}