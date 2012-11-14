import guessNumber.GuesserGame;
import guessNumber.INumberGenerator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GameTest {
    @Test
    public void should_return_you_win_given_correct_input(){
        INumberGenerator numberGenerator = new FakeNumberGenerator();
        GuesserGame guesserGame = new GuesserGame(numberGenerator);
        String result = guesserGame.accept("1234");
        assertEquals("You win", result);
        //assert game exit
    }

    @Test
    public void should_fail_and_return_0a0b(){
        INumberGenerator numberGenerator = new FakeNumberGenerator();
        GuesserGame guesserGame = new GuesserGame(numberGenerator);
        String result = guesserGame.accept("5678");
        assertEquals("0a0b", result);
    }

    @Test
    public void should_print_you_win_given_second_try_succeed(){
        INumberGenerator numberGenerator = new FakeNumberGenerator();
        GuesserGame guesserGame = new GuesserGame(numberGenerator);
        String result = guesserGame.accept("5678");
        assertEquals("0a0b", result);
        result = guesserGame.accept("1234");
        assertEquals("You win", result);
    }


    class FakeNumberGenerator implements INumberGenerator{
        @Override
        public int[] generate() {
            return new int[]{1,2,3,4};
        }
    }
}

