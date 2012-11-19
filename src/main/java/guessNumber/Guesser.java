package guessNumber;

import guessNumber.exception.InvalidInputException;
import guessNumber.exception.MaximumTriesExceedException;
import guessNumber.generator.INumberGenerator;
import guessNumber.model.UniqueNumber;

public class Guesser {
    private static final int MAXIMUM_TRIES = 6;
    private int tries = 0;
    private final UniqueNumber randomNumber;

    public Guesser(INumberGenerator numberGenerator) {
        randomNumber = numberGenerator.generate();
    }

    public GuessResult validate(String input){
        GuessResult guessResult = randomNumber.verify(toUniqueNumber(input));
        if(!guessResult.isCorrect()){
            tries++;
            if (tries >= MAXIMUM_TRIES) {
                throw new MaximumTriesExceedException();
            }
        }
        return guessResult;
    }

    private UniqueNumber toUniqueNumber(String input){
        UniqueNumber number = new UniqueNumber(INumberGenerator.ALLOWED_DIGITS);
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(!number.add(chars[i])){
                throw new InvalidInputException();
            }
        }
        return number;
    }
}