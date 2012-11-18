package guessNumber;

import guessNumber.exception.MaximumTriesExceedException;
import guessNumber.generator.INumberGenerator;
import guessNumber.guessor.Guesser;
import guessNumber.model.UniqueNumber;

public class GuessNumberApp {

    private Guesser guesser;
    private static final int MAXIMUM_TRIES = 6;
    private int tries = 0;

    public GuessNumberApp(INumberGenerator numberGenerator) {
        UniqueNumber randomNumber = numberGenerator.generate1();
        guesser = new Guesser(randomNumber);
    }

    public String accept(String input) {
        String result = guesser.verify(UniqueNumber.toUniqueNumber(input));
        if(!result.equalsIgnoreCase("4a0b")){
            tries++;
            if (tries >= MAXIMUM_TRIES) {
                throw new MaximumTriesExceedException();
            }
        }
        return result;
    }

}