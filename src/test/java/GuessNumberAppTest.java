import guessNumber.GuessNumberApp;
import guessNumber.generator.INumberGenerator;
import guessNumber.model.UniqueNumber;
import guessNumber.exception.InvalidInputException;
import guessNumber.exception.MaximumTriesExceedException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GuessNumberAppTest {

    private GuessNumberApp guessNumberApp;

    @Before
    public void setup(){
        INumberGenerator numberGenerator = new FakeNumberGenerator();
        guessNumberApp = new GuessNumberApp(numberGenerator);
    }

    @Test
    public void should_return_you_win_given_correct_input(){
        String result = guessNumberApp.accept("1234");
        assertEquals("4a0b", result);
    }

    @Test
    public void should_fail_and_return_0a0b(){
        String result = guessNumberApp.accept("5678");
        assertEquals("0a0b", result);
    }

    @Test
    public void should_print_you_win_given_second_try_succeed(){
        String result = guessNumberApp.accept("5678");
        assertEquals("0a0b", result);
        result = guessNumberApp.accept("1234");
        assertEquals("4a0b", result);
    }

    @Test(expected = MaximumTriesExceedException.class)
    public void should_print_game_over_and_exit_given_six_tries_failed(){
        for(int i = 0; i < 6; i++){
            guessNumberApp.accept("5678");
        }
    }

    @Test(expected = InvalidInputException.class)
    public void should_fail_given_input_more_than_four(){
        guessNumberApp.accept("ABCDEFG");
        guessNumberApp.accept("123456");
    }

    @Test(expected = InvalidInputException.class)
    public void should_fail_given_input_not_number(){
        guessNumberApp.accept("ABCD");
    }

    @Test(expected = InvalidInputException.class)
    public void should_fail_given_input_number_with_duplication(){
        guessNumberApp.accept("1123");
    }

    class FakeNumberGenerator implements INumberGenerator {
        @Override
        public UniqueNumber generate1() {
            return new UniqueNumberBuilder().withNumbers(new int[]{1,2,3,4}).build();
        }
    }
}

