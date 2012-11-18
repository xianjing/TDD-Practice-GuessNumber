import guessNumber.Guesser;
import guessNumber.generator.INumberGenerator;
import guessNumber.guessor.GuessResult;
import guessNumber.model.UniqueNumber;
import guessNumber.exception.InvalidInputException;
import guessNumber.exception.MaximumTriesExceedException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GuesserTest {

    private Guesser guesser;

    @Before
    public void setup(){
        INumberGenerator numberGenerator = new FakeNumberGenerator();
        guesser = new Guesser(numberGenerator);
    }

    @Test
    public void should_return_you_win_given_correct_input(){
        GuessResult result = guesser.validate("1234");
        assertEquals("You win", result.toString());
    }

    @Test
    public void should_fail_and_return_0a0b(){
        String result = guesser.validate("5678").toString();
        assertEquals("0a0b", result);
    }

    @Test
    public void should_print_you_win_given_second_try_succeed(){
        String result = guesser.validate("5678").toString();
        assertEquals("0a0b", result);
        result = guesser.validate("1234").toString();
        assertEquals("You win", result);
    }

    @Test(expected = MaximumTriesExceedException.class)
    public void should_print_game_over_and_exit_given_six_tries_failed(){
        for(int i = 0; i < 6; i++){
            guesser.validate("5678");
        }
    }

    @Test(expected = InvalidInputException.class)
    public void should_fail_given_input_more_than_four(){
        guesser.validate("ABCDEFG");
        guesser.validate("123456");
    }

    @Test(expected = InvalidInputException.class)
    public void should_fail_given_input_not_number(){
        guesser.validate("ABCD");
    }

    @Test(expected = InvalidInputException.class)
    public void should_fail_given_input_number_with_duplication(){
        guesser.validate("1123");
    }

    class FakeNumberGenerator implements INumberGenerator {
        @Override
        public UniqueNumber generate() {
            return new UniqueNumberBuilder().withNumbers(new int[]{1,2,3,4}).build();
        }
    }
}

